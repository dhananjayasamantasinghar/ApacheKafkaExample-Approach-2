package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.KafkaMessage;
import com.kafka.provider.KafkaProducer;

@RestController
public class SimpleKafkaController {

	@Autowired
	private KafkaProducer producer;

	@GetMapping("/publish")
	public String post(@RequestBody KafkaMessage kafkaMessage) {
		return producer.send(kafkaMessage, "TEST_TOPIC");
	}
	
	@GetMapping("/send/{message}")
	public String send(@PathVariable String message){
		
		return producer.send(new KafkaMessage(message), "TEST_TOPIC");
		
	}
}
