package com.lenovo.m2.integral.soa.service.test;

import com.lenovo.m2.integral.soa.api.IntegralRewardService;
import com.lenovo.m2.integral.soa.domain.IntegralReward;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by admin on 2017/10/17.
 */
public class IntegralRewardServiceTest extends BaseServiceTest {

    @Autowired
    private IntegralRewardService integralRewardService;

    /**
     * 惠商订单返还积分
     */
    @Test
    public void getExchangeRecordTest(){
        try {
            IntegralReward integralReward = new IntegralReward();
            integralReward.setLenovoId("1001");
            integralReward.setOrderCode(1001L);
            integralReward.setShopId(14);
            integralReward.setPayOrThrow(0);
            integralReward.setPayMode(0);
            integralReward.setPayOrThrowTime(new Date());
            integralReward.setItemCode("1001");
            integralReward.setItemName("商品1001");
            integralReward.setItemPrice(1288800L);
            integralReward.setItemGroupId(999);
            integralReward.setItemLogistics(0);
            integralReward.setItemFlag(1);

            integralRewardService.hsIntegralReward(integralReward);
            System.out.println("over");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
