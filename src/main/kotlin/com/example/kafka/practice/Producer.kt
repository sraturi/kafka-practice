package com.example.kafka.practice

import com.example.kafka.practice.repository.LogDocument
import com.example.kafka.practice.repository.LogRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class LogProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

	fun sendLog(message: String) {
		kafkaTemplate.send("logs", message)
	}
}

@RestController
@RequestMapping("/logs")
class Producer(private val logProducer: LogProducer, private val repository: LogRepository) {

	@PostMapping
	fun logMessage(@RequestBody log: String) {
		logProducer.sendLog(log)
	}

	@GetMapping
	fun logMessage(): List<LogDocument> {
		return repository.findAll().toIterable().toList()
	}
}
