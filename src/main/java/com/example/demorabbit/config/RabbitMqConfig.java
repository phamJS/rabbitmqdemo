package com.example.demorabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchage.name}")
    private String exchange;

    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with("routing_key");
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }
}
