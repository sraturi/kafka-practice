package com.example.kafka.practice

import com.example.kafka.practice.repository.LogDocument
import com.example.kafka.practice.repository.LogRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class Consumer(val repository: LogRepository) {

//	this will create the topics automatically. See docker compose and application properties files to disable it
	@KafkaListener(topics = ["logs"], groupId = "log_group")
	fun listen(logMessage: String) {
		println("Received Log: $logMessage")
		repository.insert(LogDocument(UUID.randomUUID().toString(), logMessage, Date.from(Instant.now()))).block()
		println(repository.count().block())
	}
}
