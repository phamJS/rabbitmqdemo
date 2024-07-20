package com.example.demorabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqPublisher {

    @Value("${rabbitmq.exchage.name}")
    private String exchange;

    @Value(("routing_key"))
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqPublisher.class);

    public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {

        LOGGER.info(String.format("Send message -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
