package com.lankaguide.tripplanner.model.activity.transport.flight

import com.lankaguide.tripplanner.model.activity.transport.Transport
import com.lankaguide.tripplanner.model.place.transport.Airport

import java.time.Duration
import java.time.ZonedDateTime

data class Flight(val departureAirport: Airport, val arrivalAirport: Airport,
                  val code: String, val depature: ZonedDateTime,
                  val arrival: ZonedDateTime, val type: Type,
                  val connection: Connection? = null) :
        Transport(departureAirport, arrivalAirport, depature, arrival) {

    val duration: Duration = Duration.between(arrival, depature)

    enum class Type {
        DOMESTIC,
        INTERNATIONAL
    }

    class Connection(val to : Type?)
}