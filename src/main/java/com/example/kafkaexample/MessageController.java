package com.example.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api-kafka/")
@AllArgsConstructor
public class MessageController {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@PostMapping(value="/{message}")
	public void postKafka(@PathVariable String message) {
		kafkaTemplate.send(KafkaVariables.TOPIC,message);
	}

	@GetMapping(value="/{message}")
	public void getKafka(@PathVariable String message) {
		kafkaTemplate.send(KafkaVariables.TOPIC,message);
	}
	
}
