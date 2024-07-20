package com.example.demorabbit.controller;

import com.example.demorabbit.publisher.RabbitMqPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private RabbitMqPublisher rabbitMqPublisher;

    public MessageController(RabbitMqPublisher rabbitMqPublisher) {
        this.rabbitMqPublisher = rabbitMqPublisher;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message){

        rabbitMqPublisher.sendMessage(message);
        return ResponseEntity.ok("message sent to RabbitMQ");
    }
}
