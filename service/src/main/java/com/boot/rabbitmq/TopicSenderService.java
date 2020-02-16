package com.boot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author jinjunzhu
 * @date 2020/2/16
 */
@Service
public class TopicSenderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send1(String message) {
        logger.info("topic sender1 : " + message);
        rabbitTemplate.convertAndSend("topicExchange", "topic.message", message);
    }

    public void send2(String message) {
        logger.info("topic sender2 : " + message);
        rabbitTemplate.convertAndSend("topicExchange", "topic.message2", message);
    }
}
