package com.boot;

import com.boot.dto.UserDto;
import com.boot.rabbitmq.DirectSenderService;
import com.support.AbstractSpringbootTest;
import org.junit.Test;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 */
public class RabbitmqDirectTest extends AbstractSpringbootTest {

    @Resource
    private DirectSenderService directSenderService;

    @Test
    public void sendString() {
        String context = "hello direct, " + LocalDate.now();
        directSenderService.sendString(context);
    }

    @Test
    public void sendObject() {
        String context = "hello direct, " + LocalDate.now();
        logger.info("direct sender : " + context);
        UserDto user = new UserDto();
        user.setId(1);
        user.setUsername("jinjunzhu");
        user.setPassword("123456");
        user.setCreateTime(LocalDateTime.now());
        directSenderService.sendObject(user);
    }
}
