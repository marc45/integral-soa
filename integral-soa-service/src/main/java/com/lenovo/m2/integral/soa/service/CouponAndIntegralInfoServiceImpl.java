package com.lenovo.m2.integral.soa.service;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.couponV2.api.model.SalescouponsApi;
import com.lenovo.m2.couponV2.api.service.SalescouponsService;
import com.lenovo.m2.integral.soa.api.CouponAndIntegralInfoService;
import com.lenovo.m2.integral.soa.api.IntegralResultCode;
import com.lenovo.m2.integral.soa.domain.CouponAndIntegralInfo;
import com.lenovo.m2.integral.soa.manager.CouponAndIntegralInfoManager;
import com.lenovo.m2.integral.soa.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/2/24.
 */
@Service("couponAndIntegralInfoService")
public class CouponAndIntegralInfoServiceImpl implements CouponAndIntegralInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouponAndIntegralInfoServiceImpl.class);

    @Autowired
    private CouponAndIntegralInfoManager couponAndIntegralInfoManager;

    //优惠券接口
    @Autowired
    private SalescouponsService salescouponsService;

    /**
     * 根据优惠券id查询优惠券和积分信息
     * @param couponId 优惠券id
     * @return
     */
    @Override
    public RemoteResult<CouponAndIntegralInfo> getCouponInfo(String couponId) {
        LOGGER.info("getCouponInfo Start:"+couponId);

        RemoteResult<CouponAndIntegralInfo> remoteResult = new RemoteResult<CouponAndIntegralInfo>();

        try {
            //调用优惠券接口，获取优惠券信息
            RemoteResult<SalescouponsApi> salescouponsById = salescouponsService.getSalescouponsById(Long.parseLong(couponId));
            if (!salescouponsById.isSuccess()){
                remoteResult.setResultCode(IntegralResultCode.GETCOUPONINFO_FAIL);
                remoteResult.setResultMsg("查询优惠券信息失败");
                LOGGER.error(JacksonUtil.toJson(salescouponsById)+";"+couponId);
                return remoteResult;
            }
            SalescouponsApi salescouponsApi = salescouponsById.getT();

            //查询数据库绑定记录，并将实时查询到的优惠券部分信息填充进去
            CouponAndIntegralInfo couponInfo = couponAndIntegralInfoManager.getCouponInfo(couponId);
            if (couponInfo==null){
                remoteResult.setResultCode(IntegralResultCode.SELECT_FAIL);
                remoteResult.setResultMsg("没有查到绑定记录");
                LOGGER.info("getCouponInfo End:"+ JacksonUtil.toJson(remoteResult));
                return remoteResult;
            }
            couponInfo.setPlatform(salescouponsApi.getTerminal());
            couponInfo.setUseScope(salescouponsApi.getDescription());
            couponInfo.setFromtime(salescouponsApi.getFromtime());
            couponInfo.setTotime(salescouponsApi.getTotime());

            remoteResult.setT(couponInfo);
            remoteResult.setSuccess(true);
            remoteResult.setResultMsg("查询成功！");
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);

        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常");
            LOGGER.error(e.getMessage(),e);
        }

        LOGGER.info("getCouponInfo End:"+ JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }

    /**
     * 添加优惠券和积分的绑定信息
     * @param couponId 优惠券id
     * @param memberId 绑定人id
     * @param integralNum 积分数量
     * @param state 是否显示，0不显示，1显示
     * @return
     */
    @Override
    public RemoteResult addCouponInfo(String couponId, String memberId, Integer integralNum, Integer state) {
        LOGGER.info("addCouponInfo Start:"+couponId+";"+memberId+";"+integralNum+";"+state);

        RemoteResult remoteResult = new RemoteResult();

        try {
            Date date = new Date();

            //调用优惠券接口，获取优惠券信息
            RemoteResult<SalescouponsApi> salescouponsById = salescouponsService.getSalescouponsById(Long.parseLong(couponId));
            if (!salescouponsById.isSuccess()){
                remoteResult.setResultCode(IntegralResultCode.GETCOUPONINFO_FAIL);
                remoteResult.setResultMsg("查询优惠券信息失败");
                LOGGER.error(JacksonUtil.toJson(salescouponsById)+";"+couponId);
                return remoteResult;
            }

            SalescouponsApi salescouponsApi = salescouponsById.getT();

            //解析返回值，获取信息，封装到对象中
            CouponAndIntegralInfo couponAndIntegralInfo = new CouponAndIntegralInfo();

            couponAndIntegralInfo.setCouponId(couponId);
            couponAndIntegralInfo.setCouponMoney(salescouponsApi.getAmount());
            couponAndIntegralInfo.setCouponName(salescouponsApi.getName());
            couponAndIntegralInfo.setCreateId(memberId);
            couponAndIntegralInfo.setCreatetime(date);
            couponAndIntegralInfo.setFromtime(salescouponsApi.getFromtime());
            couponAndIntegralInfo.setTotime(salescouponsApi.getTotime());
            couponAndIntegralInfo.setGetstarttime(salescouponsApi.getGetstarttime());
            couponAndIntegralInfo.setGetendtime(salescouponsApi.getGetendtime());
            couponAndIntegralInfo.setIntegralNum(integralNum);
            couponAndIntegralInfo.setMaxNum(salescouponsApi.getMaxnumber());
            couponAndIntegralInfo.setPlatform(salescouponsApi.getTerminal());
            couponAndIntegralInfo.setUseScope(salescouponsApi.getDescription());
            couponAndIntegralInfo.setUpdateId(memberId);
            couponAndIntegralInfo.setUpdatetime(date);
            couponAndIntegralInfo.setState(state);

            //添加绑定记录
            couponAndIntegralInfoManager.addCouponInfo(couponAndIntegralInfo);

            remoteResult.setSuccess(true);
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);
            remoteResult.setResultMsg("绑定成功");
        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常");
            LOGGER.error(e.getMessage(),e);
        }
        LOGGER.info("addCouponInfo End:"+JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }

    /**
     * 分页查询优惠券绑定积分的记录
     * @param pageQuery 分页条件对象
     * @param couponAndIntegralInfo 查询条件对象
     * @return
     */
    @Override
    public RemoteResult<PageModel2<CouponAndIntegralInfo>> getCouponInfoByPage(PageQuery pageQuery, CouponAndIntegralInfo couponAndIntegralInfo) {
        LOGGER.info("getCouponInfoByPage Start:"+JacksonUtil.toJson(pageQuery)+";"+JacksonUtil.toJson(couponAndIntegralInfo));

        RemoteResult<PageModel2<CouponAndIntegralInfo>> remoteResult = new RemoteResult<PageModel2<CouponAndIntegralInfo>>();

        try {

            PageModel2<CouponAndIntegralInfo> couponInfoByPage = couponAndIntegralInfoManager.getCouponInfoByPage(pageQuery, couponAndIntegralInfo);

            remoteResult.setSuccess(true);
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);
            remoteResult.setResultMsg("查询成功");
            remoteResult.setT(couponInfoByPage);
        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常");
            LOGGER.error(e.getMessage(),e);
        }

        LOGGER.info("getCouponInfoByPage End:"+ JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }

    /**
     * 修改绑定记录，只能修改积分数量或者是否显示
     * @param memberId 修改人id
     * @param integralNum 积分数量
     * @param state 是否显示，0不显示，1显示
     * @return
     */
    @Override
    public RemoteResult updateCouponInfo(String couponId,String memberId, Integer integralNum, Integer state) {
        LOGGER.info("updateCouponInfo Start:"+memberId+";"+integralNum+";"+state);

        RemoteResult remoteResult = new RemoteResult();

        try {
            CouponAndIntegralInfo couponAndIntegralInfo = new CouponAndIntegralInfo();
            Date date = new Date();
            couponAndIntegralInfo.setUpdatetime(date);
            couponAndIntegralInfo.setUpdateId(memberId);
            couponAndIntegralInfo.setIntegralNum(integralNum);
            couponAndIntegralInfo.setState(state);
            couponAndIntegralInfo.setCouponId(couponId);

            couponAndIntegralInfoManager.updateCouponInfo(couponAndIntegralInfo);

            remoteResult.setSuccess(true);
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);
            remoteResult.setResultMsg("修改成功");
        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常");
            LOGGER.error(e.getMessage(),e);
        }

        LOGGER.info("updateCouponInfo End:"+ JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }

    /**
     * 前端页面获取所有可以兑换的优惠券信息
     * @return
     */
    @Override
    public RemoteResult<List<CouponAndIntegralInfo>> getAllCouponInfo() {

        RemoteResult<List<CouponAndIntegralInfo>> remoteResult = new RemoteResult<List<CouponAndIntegralInfo>>();

        try {
            //封装查询条件
            CouponAndIntegralInfo couponAndIntegralInfo = new CouponAndIntegralInfo();
            Date date = new Date();
            couponAndIntegralInfo.setDate(date);

            List<CouponAndIntegralInfo> allCouponInfo = couponAndIntegralInfoManager.getAllCouponInfo(couponAndIntegralInfo);
            if (allCouponInfo!=null && allCouponInfo.size()>0){
                //循环遍历结果集，调用优惠券接口，判断是否还有库存，设置状态值
                for (CouponAndIntegralInfo info : allCouponInfo) {
                    String couponId = info.getCouponId();
                    //调用优惠券接口，获取优惠券信息
                    RemoteResult<SalescouponsApi> salescouponsById = salescouponsService.getSalescouponsById(Long.parseLong(couponId));
                    if (!salescouponsById.isSuccess()){
                        remoteResult.setResultCode(IntegralResultCode.GETCOUPONINFO_FAIL);
                        remoteResult.setResultMsg("查询优惠券信息失败");
                        LOGGER.error(JacksonUtil.toJson(salescouponsById)+";"+couponId);
                        return remoteResult;
                    }
                    SalescouponsApi salescouponsApi = salescouponsById.getT();
                    Integer iscanget = salescouponsApi.getIscanget();
                    if (iscanget==0){
                        info.setSellout(0);
                        continue;
                    }
                    Integer maxnumber = salescouponsApi.getMaxnumber();
                    if (maxnumber==0){
                        //不限制发放张数
                        info.setSellout(1);
                        continue;
                    }
                    Integer sendnumber = salescouponsApi.getSendnumber();
                    if (sendnumber==null){
                        info.setSellout(1);
                        continue;
                    }
                    //判断是否还有剩余的优惠券可以发放
                    if (maxnumber-sendnumber>0){
                        info.setSellout(1);
                    }else {
                        info.setSellout(0);
                    }
                }
            }
            remoteResult.setT(allCouponInfo);
            remoteResult.setSuccess(true);
            remoteResult.setResultCode(IntegralResultCode.SUCCESS);
            remoteResult.setResultMsg("查询成功");
        }catch (Exception e){
            remoteResult.setResultCode(IntegralResultCode.FAIL);
            remoteResult.setResultMsg("系统异常");
            LOGGER.error(e.getMessage(),e);
        }

        LOGGER.info("getAllCouponInfo End:"+ JacksonUtil.toJson(remoteResult));
        return remoteResult;
    }
}
