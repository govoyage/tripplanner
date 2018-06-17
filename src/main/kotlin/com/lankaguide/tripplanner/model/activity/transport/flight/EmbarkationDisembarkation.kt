package com.lankaguide.tripplanner.model.activity.transport.flight

import com.lankaguide.tripplanner.model.place.transport.Airport
import java.time.Duration
import java.time.ZonedDateTime

abstract class EmbarkationDisembarkation(open val start: ZonedDateTime, open val end: ZonedDateTime)

data class InternationalEP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, departure: ZonedDateTime,
                duration: Duration = Duration.ofHours(2).plusMinutes(30))
            : this(airport, departure.minus(duration), departure)
    var checkIn : Boolean = true
    var baggageCheckIn : Boolean = true
    var security : Boolean = true
    var immigration : Boolean = true
}

data class InternationalDP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, arrival: ZonedDateTime,
                duration: Duration = Duration.ofHours(1).plusMinutes(30))
            : this(airport, arrival, arrival.plus(duration))
    var immigration : Boolean = true
    var baggagePickup: Boolean = true
    var customs : Boolean = true
}

data class DomesticEP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, departure: ZonedDateTime,
                duration: Duration = Duration.ofHours(1).plusMinutes(30))
            : this(airport, departure.minus(duration), departure)
    var checkIn : Boolean = true
    var baggageCheckIn : Boolean = true
    var security : Boolean = true
}

data class DomesticDP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, arrival: ZonedDateTime, duration: Duration = Duration.ofHours(1))
            : this(airport, arrival, arrival.plus(duration))
    var baggagePickup: Boolean = true
}

data class DomConToDomDP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, arrival: ZonedDateTime, duration: Duration = Duration.ofMinutes(30))
            : this(airport, arrival, arrival.plus(duration))
    var baggagePickup: Boolean = false
}

data class DomConToIntEP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, departure: ZonedDateTime,
                duration: Duration = Duration.ofHours(1).plusMinutes(30))
            : this(airport, departure.minus(duration), departure)
    var checkIn : Boolean = true
    var baggageCheckIn : Boolean = true
    var security : Boolean = true
    var immigration : Boolean = false
}

data class DomConToIntDP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, arrival: ZonedDateTime, duration: Duration = Duration.ofMinutes(30))
            : this(airport, arrival, arrival.plus(duration))
    var baggagePickup: Boolean = false
}

data class IntConToIntDP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, arrival: ZonedDateTime, duration: Duration = Duration.ofMinutes(30))
            : this(airport, arrival, arrival.plus(duration))
    var baggagePickup: Boolean = false
    var immigration : Boolean = false
    var customs : Boolean = false
}

data class IntConToDomDP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, arrival: ZonedDateTime,
                duration: Duration = Duration.ofHours(1).plusMinutes(30))
            : this(airport, arrival, arrival.plus(duration))
    var immigration : Boolean = true
    var baggagePickup: Boolean = true
    var customs : Boolean = true
}

data class IntConFromIntEP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, departure: ZonedDateTime, duration: Duration = Duration.ofMinutes(30))
            : this(airport, departure.minus(duration), departure)
    var checkIn : Boolean = false
    var baggageCheckIn : Boolean = false
    var security : Boolean = true
    var immigration : Boolean = false
}

data class IntConFromDomEP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, departure: ZonedDateTime, duration: Duration = Duration.ofHours(1))
            : this(airport, departure.minus(duration), departure)
    var checkIn : Boolean = false
    var baggageCheckIn : Boolean = false
    var security : Boolean = true
    var immigration : Boolean = true
}

data class DomConFromIntEP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, departure: ZonedDateTime, duration: Duration = Duration.ofMinutes(45))
            : this(airport, departure.minus(duration), departure)
    var checkIn : Boolean = false
    var baggageCheckIn : Boolean = true
    var security : Boolean = true
}

data class DomConFromDomEP(private val airport: Airport, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : EmbarkationDisembarkation(start, end) {
    constructor(airport: Airport, departure: ZonedDateTime, duration: Duration = Duration.ofMinutes(45))
            : this(airport, departure.minus(duration), departure)
    var checkIn : Boolean = false
    var baggageCheckIn : Boolean = false
    var security : Boolean = true
}
