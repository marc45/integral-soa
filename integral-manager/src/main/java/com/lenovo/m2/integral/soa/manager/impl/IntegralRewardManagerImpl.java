package com.lenovo.m2.integral.soa.manager.impl;

import com.lenovo.m2.integral.soa.dao.IntegralRewardMapper;
import com.lenovo.m2.integral.soa.domain.IntegralReward;
import com.lenovo.m2.integral.soa.manager.IntegralRewardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/10/31.
 * 惠商积分奖励服务
 */
@Service("integralRewardManager")
@Transactional
public class IntegralRewardManagerImpl implements IntegralRewardManager{

    @Autowired
    private IntegralRewardMapper integralRewardMapper;

    /**
     * 根据订单号、商品code和商品行项目标识查询唯一记录
     * @param integralReward
     * @return
     */
    public IntegralReward getIntegralReward(IntegralReward integralReward){
        return integralRewardMapper.getIntegralReward(integralReward);
    }

    /**
     * 保存积分奖励记录
     * @param integralReward
     * @return
     */
    public int saveIntegralReward(IntegralReward integralReward){
        return integralRewardMapper.saveIntegralReward(integralReward);
    }

    /**
     * 根据订单号、商品code、商品行项目标识和积分发放状态，修改发放状态
     * @param integralReward
     * @return
     */
    public int updateIntegralReward(IntegralReward integralReward){
        return integralRewardMapper.updateIntegralReward(integralReward);
    }

    /**
     * 根据订单号、商品code、商品行项目标识，修改发放状态
     * @param integralReward
     * @return
     */
    public int updateIntegralRewardStatus(IntegralReward integralReward){
        return integralRewardMapper.updateIntegralRewardStatus(integralReward);
    }

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    public int deleteIntegralRewardById(Long id){
        return integralRewardMapper.deleteIntegralRewardById(id);
    }

    //根据记录id修改发放状态
    public int updateStatusById(IntegralReward integralReward){
        return integralRewardMapper.updateStatusById(integralReward);
    }

}
