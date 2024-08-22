package com.example.kafka.practice

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
class LogProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

	fun sendLog(message: String) {
		kafkaTemplate.send("logs", message)
	}
}

@RestController
@RequestMapping("/logs")
class Producer(private val logProducer: LogProducer) {

	@PostMapping
	fun logMessage(@RequestBody log: String) {
		logProducer.sendLog(log)
	}
}
