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
 * 六种工作模式：simple/work/{publish/subscribe}/routing/topic/RPC
 */
@Service
public class ReceiverService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    @RabbitListener(queues = {"simple"})
    public void processSimple(Message message) {
        logger.info("Receiver : {}", new String(message.getBody()));
    }
}
