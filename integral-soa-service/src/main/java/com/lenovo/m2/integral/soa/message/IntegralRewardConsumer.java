package com.lenovo.m2.integral.soa.message;

import com.lenovo.kafka.api.core.consumer.KafkaConsumer;
import com.lenovo.kafka.api.core.handler.BaseConsumerHandler;
import com.lenovo.m2.integral.soa.api.IntegralRewardService;
import com.lenovo.m2.integral.soa.domain.IntegralReward;
import com.lenovo.m2.integral.soa.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2017/6/14.
 * 惠商积分奖励
 */
public class IntegralRewardConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.lenovo.m2.integral.soa.integralReward");

    private KafkaConsumer kafkaConsumer;

    @Autowired
    private IntegralRewardService integralRewardService;

    public IntegralRewardConsumer(KafkaConsumer kafkaConsumer){
        this.kafkaConsumer = kafkaConsumer;
        this.kafkaConsumer.start(new ConsumerHandler());
    }

    private class ConsumerHandler implements BaseConsumerHandler {
        @Override
        public void execute(String message) {
            LOGGER.info("订单支付或抛单后==惠商积分奖励消息=="+message);
            try {
                IntegralReward integralReward = JacksonUtil.fromJson(message, IntegralReward.class);
                integralRewardService.hsIntegralReward(integralReward);
            }catch (Exception e){
                LOGGER.error("订单支付或抛单后==惠商积分奖励出现异常=="+message+"=="+e.getMessage(),e);
            }
        }
    }
}
