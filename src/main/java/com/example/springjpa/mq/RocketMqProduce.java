package com.example.springjpa.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class RocketMqProduce {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer defaultMQProducer=new DefaultMQProducer("group");
        Message message=new Message();
        message.setTopic("mytopic1");
        message.setBody("hello world".getBytes("utf-8"));
        defaultMQProducer.setNamesrvAddr("192.168.0.104:9876");
        defaultMQProducer.start();
        defaultMQProducer.setCreateTopicKey("111");
        SendResult result=defaultMQProducer.send(message);
        System.out.println(result.getSendStatus().name());
    }
}
