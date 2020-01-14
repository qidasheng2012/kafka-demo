package com.it.kafka.controller;

import com.it.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProvider;

    @RequestMapping("/test/{orderId}/{orderNum}")
    public void test(@PathVariable long orderId, @PathVariable String orderNum) {
        kafkaProvider.sendMessage(orderId, orderNum, LocalDateTime.now());
    }
}
