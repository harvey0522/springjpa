package com.example.springjpa.mq;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Slf4j
public class RocketMqProduceDelay {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer defaultMQProducer=new DefaultMQProducer("group1");
        Message message=new Message();
        message.setTopic("mytopic1");
        message.setBody("88888".getBytes("utf-8"));
        message.setDelayTimeLevel(6);
        defaultMQProducer.setNamesrvAddr("192.168.0.104:9876");
        defaultMQProducer.start();
        SendResult result=defaultMQProducer.send(message, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                Long id=(long)arg;

                return null;
            }
        },"id");
        System.out.println(result.getSendStatus().name());
        System.out.println(LocalDateTime.now());

    }

    public static void testDelay() throws Exception {
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

    public void transcation() throws Exception {
        TransactionMQProducer defaultMQProducer=new TransactionMQProducer("transmq");
        TransactionListener transactionListener=new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                log.info("executeLocalTransaction......"+JSON.toJSONString(msg));
                return LocalTransactionState.COMMIT_MESSAGE;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                log.info("checkLocalTransaction...."+JSON.toJSONString(msg));

                return LocalTransactionState.COMMIT_MESSAGE;
            }
        };
        defaultMQProducer.setTransactionListener(transactionListener);
        Message message=new Message();
        message.setTopic("myonly");
        StringBuilder sb=new StringBuilder();
        char[] chars={'a','b','c','d','e'};
        Random random=new Random();
        ;
        for(int i=0;i<random.nextInt(43);i++){
            sb.append(chars[i%5]);
        }
        log.info("res:{}",sb.toString().getBytes().length);
        message.setBody(sb.toString().getBytes());
        message.setDelayTimeLevel(6);
        defaultMQProducer.setNamesrvAddr("192.168.0.104:9876");
        defaultMQProducer.start();
        SendResult result=defaultMQProducer.sendMessageInTransaction(message,null);
        SendResult result2=defaultMQProducer.sendMessageInTransaction(message,null);
        System.out.println(result.getSendStatus().name());
        System.out.println(LocalDateTime.now());
    }
}
