package com.lankaguide.tripplanner.model.activity.transit

import com.lankaguide.tripplanner.model.place.transport.Airport

import java.time.ZonedDateTime

class FlightTransit(internal var airport: Airport, from: ZonedDateTime, to: ZonedDateTime) : Transit(from, to)
