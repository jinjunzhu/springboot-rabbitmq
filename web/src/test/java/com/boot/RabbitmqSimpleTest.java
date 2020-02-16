package com.boot;

import com.boot.dto.UserDto;
import com.boot.rabbitmq.SimpleSenderService;
import com.support.AbstractSpringbootTest;
import org.junit.Test;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 */
public class RabbitmqSimpleTest extends AbstractSpringbootTest {

    @Resource
    private SimpleSenderService simpleSenderService;

    @Test
    public void sendString() {
        String context = "hello simple, " + LocalDate.now();
        simpleSenderService.sendString(context);
    }

    @Test
    public void sendObject() {
        String context = "hello simple, " + LocalDate.now();
        logger.info("simple sender : " + context);
        UserDto user = new UserDto();
        user.setId(1);
        user.setUsername("jinjunzhu");
        user.setPassword("123456");
        user.setCreateTime(LocalDateTime.now());
        simpleSenderService.sendObject(user);
    }
}
