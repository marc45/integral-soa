package com.lenovo.m2.integral.soa.api;

import com.lenovo.m2.integral.soa.domain.IntegralReward;

/**
 * Created by admin on 2017/10/31.
 * 惠商积分奖励服务
 */
public interface IntegralRewardService {

    //惠商奖励积分接口
    public void hsIntegralReward(IntegralReward integralReward);

    //根据id删除积分奖励记录
    public int deleteIntegralReward(Long id);

}
