package com.boot.controller;

import com.boot.dto.UserDto;
import com.boot.rabbitmq.SimpleSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 */
@RestController
public class RabbitMqController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SimpleSenderService simpleSenderService;

    @RequestMapping("/mq/simple")
    public String heath(){
        String context = "hello simple, " + LocalDate.now();
        simpleSenderService.sendString(context);

        UserDto user = new UserDto();
        user.setId(1);
        user.setUsername("jinjunzhu");
        user.setPassword("123456");
        user.setCreateTime(LocalDateTime.now());
        simpleSenderService.sendObject(user);

        return "success";
    }
}
