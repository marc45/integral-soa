package com.lenovo.m2.integral.soa.activemq;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by yezhenyue on 2016/5/3.
 */
public class QueueSender {
    @Autowired
    private JmsTemplate jmsQueueTemplate;
    /**
     * 发送一条延迟消息到指定队列
     * @param queueName 队列名称
     * @param message 消息内容
     * @param delay 延迟时间 单位毫秒
     */
    public void sendDelayMessage(String queueName,final String message,final long delay){
        jmsQueueTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message ms = session.createTextMessage(message);
                ms.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
                return ms;
            }
        });
    }
    /**
     * 发送一条text消息到指定队列
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void sendMessage(String queueName,final String message){
        jmsQueueTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
    /**
     * 发送一条Object消息到指定队列 消息对象必须实现Serializable接口
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void sendObjectMessage(String queueName,final Serializable message){
        jmsQueueTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject(message);
                return objectMessage;
            }
        });
    }
    /**
     * 发送一条键值对消息到指定队列
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void sendMapMessage(String queueName,final Map<String,Object> message){
        jmsQueueTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                for (Map.Entry<String, Object> entry : message.entrySet()){
                    mapMessage.setObject(entry.getKey(),entry.getValue());
                }
                return mapMessage;
            }
        });
    }
}

