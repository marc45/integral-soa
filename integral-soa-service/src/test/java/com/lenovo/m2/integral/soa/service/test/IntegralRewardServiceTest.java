package com.lenovo.m2.integral.soa.service.test;

import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.api.ExchangeCouponRecordService;
import com.lenovo.m2.integral.soa.domain.ExchangeCouponRecord;
import com.lenovo.m2.integral.soa.utils.JacksonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2017/10/17.
 */
public class IntegralRewardServiceTest extends BaseServiceTest {

    @Autowired
    private ExchangeCouponRecordService exchangeCouponRecordService;

    /**
     * 根据主键查询兑换记录
     */
    @Test
    public void getExchangeRecordTest(){
        try {
            RemoteResult<ExchangeCouponRecord> exchangeRecord = exchangeCouponRecordService.getExchangeRecord("00c3f948965644dcaec31899dfd948db");
            System.out.println(JacksonUtil.toJson(exchangeRecord));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
