package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.KafkaMessage;

@Service
public class KafkaConsumerListener {

	@KafkaListener(topics = "TEST_TOPIC", group = "TEST_TOPIC_JSON_GROUP",
			containerFactory = "userKafkaListenerFactory")
	public void consumeJson(KafkaMessage message) {
		// Do other Activities
		System.out.println("Consumed JSON Message: " + message);
	}
}
