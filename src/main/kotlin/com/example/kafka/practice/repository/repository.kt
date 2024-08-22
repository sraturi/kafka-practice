package com.example.kafka.practice.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Document
data class LogDocument(@Id val id: String, val message: String, val receivedTime: Date)

// TODO create service class
@Repository
interface LogRepository : ReactiveMongoRepository<LogDocument, String>