package com.example.kafka.practice

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer {

	@KafkaListener(topics = ["logs"], groupId = "log_group" )
	fun listen(logMessage: String) {
		println("Received Log: $logMessage")
	}
}
