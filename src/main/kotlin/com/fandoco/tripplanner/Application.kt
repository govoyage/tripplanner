package com.fandoco.tripplanner

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule


@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)

    val objectMapper = ObjectMapper()
    objectMapper.registerModule(JavaTimeModule())
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
}