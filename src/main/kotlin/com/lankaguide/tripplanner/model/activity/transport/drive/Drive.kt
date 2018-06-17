package com.lankaguide.tripplanner.model.activity.transport.drive

import com.lankaguide.tripplanner.model.activity.transport.Transport
import com.lankaguide.tripplanner.model.place.Place

import java.time.Duration
import java.time.ZonedDateTime

abstract class Drive(override val from: Place, override val to: Place, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : Transport(from, to, start, end)
