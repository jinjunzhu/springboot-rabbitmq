package com.boot.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 */
@Service
public class SimpleSenderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void sendString(String message) {
        logger.info("simple sender : " + message);
        this.rabbitTemplate.convertAndSend("simple", message);
    }

    public void sendObject(Object message) {
        String messageStr = JSONObject.toJSONString(message);
        logger.info(messageStr);
        this.rabbitTemplate.convertAndSend("simple", messageStr);
    }
}
