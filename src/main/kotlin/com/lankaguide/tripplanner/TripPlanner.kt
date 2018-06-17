package com.lankaguide.tripplanner

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by prasad on 2016/11/20.
 */
@SpringBootApplication
object TripPlanner {

    private val log = LoggerFactory.getLogger(TripPlanner::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(TripPlanner::class.java, *args)
    }
}