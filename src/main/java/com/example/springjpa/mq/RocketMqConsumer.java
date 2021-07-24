package com.example.springjpa.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class RocketMqConsumer {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQPushConsumer pushConsumer=new DefaultMQPushConsumer("myconsumer");
        pushConsumer.setNamesrvAddr("192.168.0.104:9876");
        pushConsumer.subscribe("mytopic1","*");

        pushConsumer.setMessageListener(new MessageListenerConcurrently(){

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                //System.out.println("----");
                msgs.forEach(msg-> {
                    try {
                        System.out.println(new String(msg.getBody(),"utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        pushConsumer.start();
    }
}
