package com.boot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 * 六种工作模式：direct/work/{publish/subscribe}/routing/topic/RPC
 */
@Service
public class ReceiverService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    @RabbitListener(queues = {"direct"})
    public void processDirect(Message message) {
        logger.info("Receiver direct: {}", new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = {"topic.message"})
    public void processTopic(Message message) {
        logger.info("Receiver topic: {}", new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = {"topic.message2"})
    public void processTopic2(Message message) {
        logger.info("Receiver topic2: {}", new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = {"fanout.a", "fanout.b", "fanout.c"})
    public void processFanout1(Message message) {
        logger.info("Receiver fanout: {}", new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = {"headerQueue"})
    public void processHeaders(Message message) {
        logger.info("Receiver header: {}", new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = {"headerQueue2"})
    public void processHeaders1(Message message) {
        logger.info("Receiver header2: {}", new String(message.getBody()));
    }
}
