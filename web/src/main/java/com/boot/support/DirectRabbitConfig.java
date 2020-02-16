package com.boot.support;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jinjunzhu
 * @date 2020/2/14
 * 注：也可以不声明exchange和进行绑定，使用rabbitmq自带的exchange
 */
@Configuration
public class DirectRabbitConfig {
    @Bean
    public Queue direct() {
        return new Queue("direct");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding directBindingExchange(Queue direct, DirectExchange directExchange) {
        return BindingBuilder.bind(direct).to(directExchange).with("direct");
    }
}
