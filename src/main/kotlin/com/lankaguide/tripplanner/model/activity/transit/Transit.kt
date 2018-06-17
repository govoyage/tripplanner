package com.lankaguide.tripplanner.model.activity.transit

import com.lankaguide.tripplanner.model.activity.Activity
import com.lankaguide.tripplanner.model.place.transport.TransportNode

import java.time.ZonedDateTime

open class Transit(from: ZonedDateTime, to: ZonedDateTime) : Activity(from, to) {
    private val transportNode: TransportNode? = null
}
