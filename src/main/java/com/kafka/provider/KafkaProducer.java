package com.kafka.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.model.KafkaMessage;

@Service
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

	public String send(KafkaMessage kafkaMessage, String topicName) {
		kafkaTemplate.send(topicName, kafkaMessage);
		System.out.println("JSON Message Published successfully");
		return "Published successfully";
	}
}
