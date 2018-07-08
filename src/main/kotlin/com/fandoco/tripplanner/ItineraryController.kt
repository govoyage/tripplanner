package com.fandoco.tripplanner

import com.fandoco.tripplanner.model.Itinerary
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ItineraryController {

    companion object {
        private val log = LoggerFactory.getLogger(ItineraryController::class.java)
    }

    @GetMapping("/itinerary")
    fun getItinerary(@RequestParam(value = "id", required = false, defaultValue = "1") id: String):
            Itinerary {
        return getSimpleItinerary()
    }
}