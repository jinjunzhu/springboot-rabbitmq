package com.boot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jinjunzhu
 * @date 2020/2/16
 */
@Service
public class FanoutSenderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        logger.info("fanout sender : {}", message);
        rabbitTemplate.convertAndSend("fanoutExchange","", message);
    }
}
