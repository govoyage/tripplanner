package com.lankaguide.tripplanner.model.activity

import com.lankaguide.tripplanner.model.place.Place
import java.time.Duration

import java.time.ZonedDateTime

data class Visit(val place: Place, override val start: ZonedDateTime, override val end: ZonedDateTime) : Activity(start, end) {
    constructor(place: Place, start: ZonedDateTime, duration: Duration) : this(place, start, start.plus(duration))
    constructor(place: Place, duration: Duration, end: ZonedDateTime) : this(place, end.minus(duration), end)
}
