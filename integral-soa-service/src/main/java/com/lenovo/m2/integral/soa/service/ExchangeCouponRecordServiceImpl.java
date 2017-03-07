package com.lenovo.m2.integral.soa.service;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.arch.framework.domain.Tenant;
import com.lenovo.m2.couponV2.api.model.ProductruleApi;
import com.lenovo.m2.couponV2.api.model.SalescouponsApi;
import com.lenovo.m2.couponV2.api.service.SalescouponsService;
import com.lenovo.m2.integral.soa.api.ExchangeCouponRecordService;
import com.lenovo.m2.integral.soa.api.IntegralResultCode;
import com.lenovo.m2.integral.soa.domain.CouponAndIntegralInfo;
import com.lenovo.m2.integral.soa.domain.ExchangeCouponRecord;
import com.lenovo.m2.integral.soa.manager.CouponAndIntegralInfoManager;
import com.lenovo.m2.integral.soa.manager.ExchangeCouponRecordManager;
import com.lenovo.m2.integral.soa.utils.JacksonUtil;
import com.lenovo.points.client.MemPointsClient;
import com.lenovo.points.vo.MemPointsRollbackResult;
import com.lenovo.points.vo.MemPointsWriteResult;
import com.lenovo.products.cache.ProductRedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 2017/2/24.
 */
@Service("exchangeCouponRecordService")
public class ExchangeCouponRecordServiceImpl implements ExchangeCouponRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeCouponRecordServiceImpl.class);
    private static final Logger INTEGRALLOGGER = LoggerFactory.getLogger("com.lenovo.m2.integral.soa.integral");
    private static final Logger COUPONLOGGER = LoggerFactory.getLogger("com.lenovo.m2.integral.soa.coupon");


    //兑换记录manager
    @Autowired
    private ExchangeCouponRecordManager exchangeCouponRecordManager;

    //优惠券和积分信息manager
    @Autowired
    private CouponAndIntegralInfoManager couponAndIntegralInfoManager;

    //优惠券接口
    @Autowired
    private SalescouponsService salescouponsService;

    //积分接口客户端
    private MemPointsClient memPointsClient= MemPointsClient.getInstance();

    /**
     * 详情页立即兑换接口，兑换优惠券
     * @param couponId 优惠券id
     * @param agentId 兑换人id
     * @param buyerId 经销商id
     * @return
     */
    @Override
    public RemoteResult exchangeCoupon(String shopId,String couponId, String agentId,String agentCode, String buyerId) {

        LOGGER.info("exchangeCoupon Start:"+shopId+";"+couponId+";"+agentId+";"+agentCode+";"+buyerId);

        RemoteResult remoteResult = new RemoteResult();

        try {
            //根据优惠券id获取优惠券信息
            RemoteResult<SalescouponsApi> salescouponsById = salescouponsService.getSalescouponsById(Long.parseLong(couponId));
            if (!salescouponsById.isSuccess()){
                remoteResult.setResultCode(IntegralResultCode.GETCOUPONINFO_FAIL);
                remoteResult.setResultMsg("查询优惠券信息失败");
                LOGGER.error(JacksonUtil.toJson(salescouponsById)+";"+couponId);
                return remoteResult;
            }
            SalescouponsApi salescouponsApi = salescouponsById.getT();

            //获取优惠券绑定的商品code数组
            ProductruleApi productruleApi = salescouponsApi.getProductruleApi();
            if (productruleApi==null){
                remoteResult.setResultCode(IntegralResultCode.PARAMS_FAIL);
                remoteResult.setResultMsg("参数错误！");
                LOGGER.error(JacksonUtil.toJson(salescouponsById)+";"+couponId);
                return remoteResult;
            }
            String goodscodes = productruleApi.getGoodscodes();
            String[] split = goodscodes.split(",");
            Integer[] codes = new Integer[split.length];
            for (int i = 0; i < split.length; i++) {
                codes[i] = Integer.parseInt(split[i]);
            }

            //判断该用户是否可以购买这些商品
            Integer[] integers = ProductRedis.filterProducts(codes, buyerId);

            if (integers.length==0){
                //如果一件都买不了，那么该用户无法兑换此优惠券
                remoteResult.setResultCode(IntegralResultCode.COUPON_UNUSABLE);
                remoteResult.setResultMsg("签约关系不满足兑换此优惠券！");
                LOGGER.info("exchangeCoupon End:" + JacksonUtil.toJson(remoteResult));
                return remoteResult;
            }

            //查询优惠券绑定的积分信息
            CouponAndIntegralInfo couponInfo = couponAndIntegralInfoManager.getCouponInfo(couponId);
            if (couponInfo==null){
                remoteResult.setResultCode(IntegralResultCode.SELECT_FAIL);
                remoteResult.setResultMsg("没有查到绑定记录");
                LOGGER.info("exchangeCoupon End:"+ JacksonUtil.toJson(remoteResult));
                return remoteResult;
            }

            //生成要保存的兑换记录的唯一主键uuid
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");

            //扣减积分
            INTEGRALLOGGER.info("扣减积分接口参数 :CVCP;"+buyerId+";"+agentId+";"+couponInfo.getIntegralNum()+";"+uuid);
            MemPointsWriteResult mppay = memPointsClient.write("CVCP", buyerId, agentId, couponInfo.getIntegralNum(), "{\"bask_work_order\":\"" + uuid + "\"}");
            INTEGRALLOGGER.info("扣减积分接口返回 :"+JacksonUtil.toJson(mppay));

            String code = mppay.getCode();
            if ("10006".equals(code)){
                //用户积分不够扣减
                INTEGRALLOGGER.error(JacksonUtil.toJson(mppay));

                remoteResult.setResultCode(IntegralResultCode.INTEGRAL_LACK);
                remoteResult.setResultMsg(mppay.getMessage());
                LOGGER.info("exchangeCoupon End:" + JacksonUtil.toJson(remoteResult));
                return remoteResult;
            }else if (!"00000".equals(code)){
                //积分扣减失败
                INTEGRALLOGGER.error(JacksonUtil.toJson(mppay));

                remoteResult.setResultCode(IntegralResultCode.INTEGRAL_DEC_FAIL);
                remoteResult.setResultMsg(mppay.getMessage());
                LOGGER.info("exchangeCoupon End:" + JacksonUtil.toJson(remoteResult));
                return remoteResult;
            }

            //积分扣减成功了，下一步绑定优惠券
            try {
                COUPONLOGGER.info("绑优惠券接口参数 :"+shopId+";"+couponId+";"+buyerId+";"+agentId);

                Tenant tenant = new Tenant();
                tenant.setShopId(Integer.parseInt(shopId));
                RemoteResult<Boolean> booleanRemoteResult = salescouponsService.bindCoupons(tenant, Long.parseLong(couponId), buyerId, agentId);

                COUPONLOGGER.info("绑优惠券接口返回 :" + JacksonUtil.toJson(booleanRemoteResult));

                if (!booleanRemoteResult.isSuccess()){
                    //绑券失败，将扣减的积分回滚
                    MemPointsRollbackResult rollback = memPointsClient.rollback(mppay.getRecordId());
                    if (!"00000".equals(rollback.getCode())){
                        //回滚失败，打印日志
                        INTEGRALLOGGER.error(JacksonUtil.toJson(rollback)+";"+mppay.getRecordId());
                    }

                    remoteResult.setResultCode(IntegralResultCode.BINDING_FAIL);
                    remoteResult.setResultMsg("绑券失败！");
                    LOGGER.info("exchangeCoupon End:" + JacksonUtil.toJson(remoteResult));
                    return remoteResult;
                }
            }catch (Exception e){
                //出现异常，回滚积分
                MemPointsRollbackResult rollback = memPointsClient.rollback(mppay.getRecordId());
                if (!"00000".equals(rollback.getCode())){
                    //回滚失败，打印日志
                    INTEGRALLOGGER.error(JacksonUtil.toJson(rollback)+";"+mppay.getRecordId());
                }

                remoteResult.setResultCode(IntegralResultCode.FAIL);
                remoteResult.setResultMsg("系统异常！");
                LOGGER.error(e.getMessage(), e);
                LOGGER.info("exchangeCoupon End:" + JacksonUtil.toJson(remoteResult));
                return remoteResult;
            }

            //绑券成功，存储兑换记录
            Date date = new Date();

            ExchangeCouponRecord exchangeCouponRecord = new ExchangeCouponRecord();
            exchangeCouponRecord.setUuid(uuid);
            exchangeCouponRecord.setCouponId(couponId);
            exchangeCouponRecord.setCouponMoney(salescouponsApi.getAmount());
            exchangeCouponRecord.setCouponName(salescouponsApi.getName());
            exchangeCouponRecord.setIntegralNum(couponInfo.getIntegralNum());
            exchangeCouponRecord.setExchangetime(date);
            exchangeCouponRecord.setAgentId(agentId);
            exchangeCouponRecord.setAgentCode(agentCode);

            exchangeCouponRecordManager.addExchangeRecord(exchangeCouponRecord);

            remoteResult.setSuccess(true);
            remoteResult.setResultMsg("兑换成功");
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);
        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常！");
            LOGGER.error(e.getMessage(), e);
        }

        LOGGER.info("exchangeCoupon End:" + JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }

    /**
     * 根据主键查询兑换记录
     * @param uuid 兑换记录主键
     * @return
     */
    @Override
    public RemoteResult<ExchangeCouponRecord> getExchangeRecord(String uuid) {
        LOGGER.info("getExchangeRecord Start:"+uuid);

        RemoteResult<ExchangeCouponRecord> remoteResult = new RemoteResult<ExchangeCouponRecord>();

        try {
            ExchangeCouponRecord exchangeRecord = exchangeCouponRecordManager.getExchangeRecord(uuid);

            remoteResult.setSuccess(true);
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);
            remoteResult.setResultMsg("查询成功");
            remoteResult.setT(exchangeRecord);
        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常");
            LOGGER.error(e.getMessage(),e);
        }

        LOGGER.info("getExchangeRecord End:"+ JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }

    /**
     * 分页查询兑换记录
     * @param pageQuery 分页条件对象
     * @param exchangeCouponRecord  查询条件对象
     * @return
     */
    @Override
    public RemoteResult<PageModel2<ExchangeCouponRecord>> getIntegralExchangeByPage(PageQuery pageQuery, ExchangeCouponRecord exchangeCouponRecord) {
        LOGGER.info("getIntegralExchangeByPage Start:"+JacksonUtil.toJson(pageQuery)+";"+JacksonUtil.toJson(exchangeCouponRecord));

        RemoteResult<PageModel2<ExchangeCouponRecord>> remoteResult = new RemoteResult<PageModel2<ExchangeCouponRecord>>();

        try {
            PageModel2<ExchangeCouponRecord> exchangeRecordByPage = exchangeCouponRecordManager.getExchangeRecordByPage(pageQuery, exchangeCouponRecord);

            remoteResult.setSuccess(true);
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);
            remoteResult.setResultMsg("查询成功");
            remoteResult.setT(exchangeRecordByPage);
        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常");
            LOGGER.error(e.getMessage(),e);
        }

        LOGGER.info("getIntegralExchangeByPage End:"+ JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }
}
