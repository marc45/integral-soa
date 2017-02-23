package com.lenovo.m2.integral.soa.message;

import com.lenovo.kafka.api.core.consumer.KafkaConsumer;
import com.lenovo.kafka.api.core.handler.BaseConsumerHandler;
import com.lenovo.m2.integral.soa.activemq.QueueSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 下单获取订单信息
 * Created by mayan3 on 2016/12/23.
 */
public class AddOrderMessageCustomer {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.lenovo.hawkeye.service.message.order");

    private KafkaConsumer kafkaConsumer;
    private QueueSender queueSender;

    public AddOrderMessageCustomer(KafkaConsumer kafkaConsumer, QueueSender queueSender) {
        this.kafkaConsumer = kafkaConsumer;
        this.queueSender = queueSender;
        this.kafkaConsumer.start(new ConsumerHandler());
    }

    private class ConsumerHandler implements BaseConsumerHandler {
        @Override
        public void execute(String orderId) {
            LOGGER.info("AddOrderMessageCustomer Start:" + orderId);
            try {
                long delay = 1000*60*3;//消息延迟3分钟投递
                queueSender.sendDelayMessage("aaaaaaaaaa",orderId,delay);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}
