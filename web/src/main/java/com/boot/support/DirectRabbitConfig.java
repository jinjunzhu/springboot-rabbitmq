package com.boot.support;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 */
@Configuration
public class DirectRabbitConfig {
    @Bean
    public Queue direct() {
        return new Queue("direct");
    }
}
