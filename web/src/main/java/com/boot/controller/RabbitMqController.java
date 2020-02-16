package com.boot.controller;

import com.boot.dto.UserDto;
import com.boot.rabbitmq.FanoutSenderService;
import com.boot.rabbitmq.DirectSenderService;
import com.boot.rabbitmq.HeadersSenderService;
import com.boot.rabbitmq.TopicSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 */
@RestController
public class RabbitMqController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private DirectSenderService directSenderService;

    @Resource
    private TopicSenderService topicSenderService;

    @Resource
    private FanoutSenderService fanoutSenderService;

    @Resource
    private HeadersSenderService headersSenderService;

    @RequestMapping("/mq/direct")
    public String direct(){
        String context = "hello direct, " + LocalDate.now();
        directSenderService.sendString(context);

        UserDto user = new UserDto();
        user.setId(1);
        user.setUsername("jinjunzhu");
        user.setPassword("123456");
        user.setCreateTime(LocalDateTime.now());
        directSenderService.sendObject(user);

        return "success";
    }

    @RequestMapping("/mq/topic")
    public String topic(){
        String context = "hello topic1, " + LocalDate.now();
        topicSenderService.send1(context);

        String context2 = "hello topic2, " + LocalDate.now();
        topicSenderService.send2(context2);

        return "success";
    }

    @RequestMapping("/mq/fanout")
    public String fanout(){
        String context = "hello fanout, " + LocalDate.now();
        fanoutSenderService.send(context);

        return "success";
    }

    @RequestMapping("/mq/headers")
    public String headers(){
        Map<String,Object> head = new HashMap<>(3);
        head.put("param1", "value1");
        headersSenderService.headerSend(head, "message1");

        head.put("param2", "value2");
        headersSenderService.headerSend(head, "message2");

        Map<String,Object> head1 = new HashMap<>(3);
        head1.put("param2", "value2");
        headersSenderService.headerSend2(head1, "message3");

        head1.put("param1", "value1");
        headersSenderService.headerSend2(head1, "message4");

        return "success";
    }
}
