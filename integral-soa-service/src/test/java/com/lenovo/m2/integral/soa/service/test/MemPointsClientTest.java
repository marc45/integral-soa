package com.lenovo.m2.integral.soa.service.test;

import com.lenovo.m2.integral.soa.utils.JacksonUtil;
import com.lenovo.points.client.MemPointsClient;
import com.lenovo.points.vo.MemPointsWriteResult;
import org.junit.Test;

import java.util.UUID;

/**
 * @Author: ShaoYuanHu
 * @Description:
 * @Date: Created in 2017-12-05
 */
public class MemPointsClientTest {
    //调用积分接口参数
    private static final String ORDER_REWARD_INTEGRAL = "MPORL";
    private static final String INTEGRALREWARD = "integralReward";

    //积分接口客户端
    private MemPointsClient memPointsClient= MemPointsClient.getInstance();

    @Test
    public void writeTest(){
        String lenovoId = "1000012";
        int integralNum = 100;

        for (int i = 0; i < 5; i++) {
            StringBuilder bask_work_order = new StringBuilder("{\"bask_work_order\":\"");
            bask_work_order.append(UUID.randomUUID().toString().replace("-",""));
            bask_work_order.append("\"}");
            System.out.println(i+"==积分接口参数==lenovoId=" + lenovoId +";integralNum="+integralNum+";bask_work_order="+bask_work_order.toString());
            MemPointsWriteResult mporl = memPointsClient.write(ORDER_REWARD_INTEGRAL, lenovoId, INTEGRALREWARD, integralNum, bask_work_order.toString());
            System.out.println(i+"==积分接口返回值==" + JacksonUtil.toJson(mporl));
        }
    }

}
