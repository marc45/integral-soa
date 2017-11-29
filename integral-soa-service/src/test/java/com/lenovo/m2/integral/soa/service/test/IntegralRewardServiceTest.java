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
            integralReward.setLenovoId("1005");
            integralReward.setOrderCode(100001L);
            integralReward.setShopId(14);
            integralReward.setPayOrThrow(0);
            integralReward.setPayMode(2);
            integralReward.setPayOrThrowTime(new Date());
            integralReward.setItemCode("1005");
            integralReward.setItemName("商品1005");
            integralReward.setItemPrice(128800L);
            integralReward.setItemGroupId(999);
            integralReward.setItemLogistics(2);
            integralReward.setItemFlag(1);

            integralRewardService.hsIntegralReward(integralReward);
            System.out.println("over");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
