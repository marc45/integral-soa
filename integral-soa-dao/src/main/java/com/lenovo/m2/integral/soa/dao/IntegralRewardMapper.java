package com.lenovo.m2.integral.soa.dao;

import com.lenovo.m2.integral.soa.domain.IntegralReward;

/**
 * 惠商积分奖励Mapper
 */
public interface IntegralRewardMapper {

    /**
     * 根据订单号、商品code和商品行项目标识查询唯一记录
     * @param integralReward
     * @return
     */
    public IntegralReward getIntegralReward(IntegralReward integralReward);

    /**
     * 保存积分奖励记录
     * @param integralReward
     * @return
     */
    public int saveIntegralReward(IntegralReward integralReward);

    /**
     * 根据订单号、商品code、商品行项目标识和积分发放状态，修改发放状态
     * @param integralReward
     * @return
     */
    public int updateIntegralReward(IntegralReward integralReward);

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    public int deleteIntegralRewardById(Long id);

}