package com.boot.support;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author jinjunzhu
 * @date 2020/2/16
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue("topic.message2");
    }

    /**
     * 将队列绑定到Topic交换器
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 将队列绑定到Topic交换器
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**
     * 将队列绑定到Topic交换器 采用#的方式
     * @param exchange
     * @param queueMessage2
     * @return
     */
    @Bean
    Binding bindingExchangeMessage2(TopicExchange exchange, Queue queueMessage2) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }
}
