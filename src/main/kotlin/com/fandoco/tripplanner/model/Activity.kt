package com.fandoco.tripplanner.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.Duration
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class Activity(val type: String, val label: String,
                    val startTime: ZonedDateTime,
                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") val endTime:
                    ZonedDateTime,
                    val startPlace: Place,
                    val endPlace: Place) :
        Comparable<Activity> {

    @JsonIgnore
    val dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm z", Locale.ENGLISH)

    override fun compareTo(other: Activity): Int {
        return startTime.compareTo(other.startTime)
    }

    constructor(type: String, label: String, startTime: ZonedDateTime
                , endTime: ZonedDateTime, place: Place) : this(type, label, startTime, endTime, place, place)

    constructor(type: String, label: String, startTime: ZonedDateTime, duration: Duration, startPlace: Place,
                endPlace: Place) :
            this(type, label, startTime, startTime.plus(duration), startPlace, endPlace)

    constructor(type: String, label: String, duration: Duration, endTime: ZonedDateTime, startPlace: Place, endPlace: Place) :
            this(type, label, endTime.minus(duration), endTime, startPlace, endPlace)

    constructor(type: String, label: String, startTime: ZonedDateTime
                , duration: Duration, place: Place) : this(type, label, startTime, startTime.plus(duration), place, place)

    constructor(type: String, label: String, duration: Duration, endTime: ZonedDateTime, place: Place) :
            this(type, label, endTime.minus(duration), endTime, place, place)

    val attributes: MutableMap<String, String> = HashMap()

    fun addAttribute(key: String, value: String) {
        attributes.put(key, value)
    }

    override fun toString(): String {

        return "$label " +
                "  ${dateFormatter.format(startTime)}, " +
                "  ${dateFormatter.format(endTime)}, " +
                "  ${startPlace.name}, " +
                "  ${endPlace.name}"
    }


    override fun equals(other: Any?): Boolean {
        if(other != null && other is Activity) {
            return this.type.equals(other.type) && this.startTime.equals(other.startTime) && this.endTime.equals(other
                    .endTime)
        } else {
            return false
        }
    }

}
