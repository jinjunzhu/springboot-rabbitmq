package com.boot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;

/**
 * @author jinjunzhu
 * @date 2020/2/16
 */
@Service
public class HeadersSenderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void headerSend(Map<String, Object> head, String msg){
        logger.info("header send message: "+msg);
        rabbitTemplate.convertAndSend("headerExchange", "headerQueue", getMessage(head, msg));
    }

    public void headerSend2(Map<String, Object> head, String msg){
        logger.info("header1 send message: "+msg);
        rabbitTemplate.convertAndSend("headerExchange2", "headerQueue2", getMessage(head, msg));
    }

    private Message getMessage(Map<String, Object> head, Object msg){
        MessageProperties messageProperties = new MessageProperties();
        for (Map.Entry<String, Object> entry : head.entrySet()) {
            messageProperties.setHeader(entry.getKey(), entry.getValue());
        }
        MessageConverter messageConverter = new SimpleMessageConverter();
        return messageConverter.toMessage(msg, messageProperties);
    }

}
