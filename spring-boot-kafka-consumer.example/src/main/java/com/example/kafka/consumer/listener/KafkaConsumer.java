package com.example.kafka.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.consumer.model.User;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="kafka_topic_01", groupId="group_01")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}
	
	@KafkaListener(topics="kafka_topic_02", groupId="group_json",
					containerFactory="userKafkaListenerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed JSON Message: " + user);
	}
}