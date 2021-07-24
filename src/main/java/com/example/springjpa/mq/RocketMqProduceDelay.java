package com.example.springjpa.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class RocketMqProduceDelay {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer defaultMQProducer=new DefaultMQProducer("group1");
        Message message=new Message();
        message.setTopic("mytopic1");
        message.setBody("88888".getBytes("utf-8"));
        message.setDelayTimeLevel(6);
        defaultMQProducer.setNamesrvAddr("192.168.0.104:9876");
        defaultMQProducer.start();
        SendResult result=defaultMQProducer.send(message);
        System.out.println(result.getSendStatus().name());
        System.out.println(LocalDateTime.now());
    }
}
