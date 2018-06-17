package com.lankaguide.tripplanner.model.activity.transport.drive

import com.lankaguide.tripplanner.model.place.Place
import java.time.Duration

import java.time.ZonedDateTime

data class RentalCar(override val from: Place, override val to: Place, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : Drive(from, to, start, end) {
    constructor(from: Place, to: Place, start: ZonedDateTime, duration: Duration) : this(from, to, start, start.plus(duration))
    constructor(from: Place, to: Place, duration: Duration, end: ZonedDateTime) : this(from, to, end.minus(duration), end)
}
