package com.example.demorabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);
    private final Queue queue;

    public RabbitMqConsumer(Queue queue) {
        this.queue = queue;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOGGER.info(String.format("Consumed: %s", message));
    }
}
