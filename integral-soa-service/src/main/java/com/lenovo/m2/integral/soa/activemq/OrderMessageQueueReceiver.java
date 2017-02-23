package com.lenovo.m2.integral.soa.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by yezhenyue on 2016/5/3.
 */
public class OrderMessageQueueReceiver implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger("com.lenovo.hawkeye.service.message.order");

    //private OrderService orderService;

    @Override
    public void onMessage(Message message) {
        try {
            if (message != null) {
                String orderId = ((TextMessage) message).getText();
                LOGGER.info("OrderMessageQueueReceiver接收到消息orderId:" + orderId);


            }else {
                LOGGER.error("OrderMessageQueueReceiver接收到消息为空");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            LOGGER.info("onMessage|Exception",e);

        }
    }

}
