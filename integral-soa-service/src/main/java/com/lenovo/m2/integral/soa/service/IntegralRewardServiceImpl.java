package com.lenovo.m2.integral.soa.service;

import com.lenovo.m2.integral.soa.api.IntegralRewardService;
import com.lenovo.m2.integral.soa.domain.IntegralReward;
import com.lenovo.m2.integral.soa.manager.IntegralRewardManager;
import com.lenovo.m2.integral.soa.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/10/31.
 * 惠商积分奖励服务
 *
 */
@Service("integralRewardService")
public class IntegralRewardServiceImpl extends BaseService implements IntegralRewardService {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.lenovo.m2.integral.soa.integralReward");

    @Autowired
    private IntegralRewardManager integralRewardManager;

    //返还积分比例
    private static final double ratio01 = 0.05;
    private static final double ratio02 = 0.03;

    //惠商奖励积分接口
    @Override
    public void hsIntegralReward(IntegralReward integralReward) {
        LOGGER.info("hsIntegralReward==参数=="+ JacksonUtil.toJson(integralReward));
        try {
            //校验参数
            boolean paramError = checkHsIntegralRewardParam(integralReward);
            if(paramError) {
                LOGGER.info("hsIntegralReward==结束==参数错误==" + JacksonUtil.toJson(integralReward));
                return;
            }
            if (integralReward.getPayOrThrow()==1&&integralReward.getPayMode()==2&&integralReward.getItemLogistics()==2){
                //线下支付，不走sec的，不奖励积分
                LOGGER.info("hsIntegralReward==结束==不奖励积分==" + JacksonUtil.toJson(integralReward));
                return;
            }
            //判断消息是否已经处理过，未处理则初始化记录
            IntegralReward reward = integralRewardManager.getIntegralReward(integralReward);
            if (reward==null){
                integralReward.setCreateBy("admin");
                integralReward.setUpdateBy("admin");
                int i = integralRewardManager.saveIntegralReward(integralReward);
                if (i<=0){
                    LOGGER.info("hsIntegralReward==结束==记录保存失败==" + JacksonUtil.toJson(integralReward));
                    return;
                }
            }else if (reward.getStatus()==1){
                LOGGER.info("hsIntegralReward==结束==已经处理过==" + JacksonUtil.toJson(integralReward));
                return;
            }
            int integralNum = countIntegralNum(integralReward);
            //修改记录状态
            integralReward.setIntegralNum(integralNum);
            integralReward.setStatus(1);
            int i = integralRewardManager.updateIntegralReward(integralReward);
            if (i<=0){
                LOGGER.info("hsIntegralReward==结束==记录状态修改为1失败==" + JacksonUtil.toJson(integralReward));
                return;
            }
            //TODO 发放积分
            if (integralNum>0){
                //应发放积分数量大于0，则调用发放积分接口

            }
            /*if ("发放积分失败"){
                integralReward.setStatus(0);
                int j = integralRewardManager.updateIntegralReward(integralReward);
                if (j<=0){
                    LOGGER.info("hsIntegralReward==结束==记录状态修改为0失败==" + JacksonUtil.toJson(integralReward));
                    return;
                }
            }*/
        }catch (Exception e){
            LOGGER.info("hsIntegralReward==出现异常==" + JacksonUtil.toJson(integralReward)+ "==" + e.getMessage(), e);
            return;
        }
        LOGGER.info("hsIntegralReward==结束==操作成功=="+ JacksonUtil.toJson(integralReward));
    }

    //计算应奖励积分，结果四舍五入
    private int countIntegralNum(IntegralReward reward){
        if (reward.getPayOrThrow()==0 ||
                (reward.getPayOrThrow()==1&&reward.getPayMode()==0&&reward.getItemLogistics()==2) ||
                (reward.getPayOrThrow()==1&&reward.getPayMode()==2&&reward.getItemLogistics()==1)){
            /**
             * 999产品组，按照实际支付金额的3%比例返回积分
             * 02商品：49,68,95产品组商品，线上支付，不走sec物流，按照实际支付金额的3%比例返回积分
             * 03商品：49,68,95产品组商品，线下支付，走sec物流，按照实际支付金额的3%比例返回积分
             */
            return (int) Math.round(reward.getItemPrice() * ratio02 / 100);
        }else if (reward.getPayOrThrow()==1&&reward.getPayMode()==0&&reward.getItemLogistics()==1){
            //01商品：49,68,95产品组商品，线上支付，走sec物流
            return (int) Math.round(reward.getItemPrice() * ratio01 / 100);
        }
        return 0;
    }

    //参数校验
    private boolean checkHsIntegralRewardParam(IntegralReward integralReward){
        String lenovoId = integralReward.getLenovoId();
        Long orderCode = integralReward.getOrderCode();
        Integer payOrThrow = integralReward.getPayOrThrow();
        Integer payMode = integralReward.getPayMode();
        String itemCode = integralReward.getItemCode();
        Long itemPrice = integralReward.getItemPrice();
        Integer itemGroupId = integralReward.getItemGroupId();
        Integer itemLogistics = integralReward.getItemLogistics();
        Integer itemFlag = integralReward.getItemFlag();
        if (isEmpty(lenovoId,itemCode) || isNull(integralReward,orderCode,payOrThrow,payMode,itemPrice,itemGroupId,itemLogistics,itemFlag)){
            //必填参数为空，返回参数错误
            return true;
        }
        if ((payOrThrow==0&&itemGroupId!=999) || (payOrThrow==1&&(itemGroupId!=49&&itemGroupId!=68&&itemGroupId!=95))){
            //标识和产品组不一致，返回参数错误
            return true;
        }
        return false;
    }

    //根据id删除积分奖励记录
    @Override
    public int deleteIntegralReward(Long id) {
        return integralRewardManager.deleteIntegralRewardById(id);
    }
}
