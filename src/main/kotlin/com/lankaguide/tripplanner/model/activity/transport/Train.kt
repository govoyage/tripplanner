package com.lankaguide.tripplanner.model.activity.transport

import com.lankaguide.tripplanner.model.place.Place
import com.lankaguide.tripplanner.model.place.transport.RailwayStation

import java.time.LocalTime
import java.time.ZonedDateTime

class Train(override val from: RailwayStation, override val to: RailwayStation, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : Transport(from, to, start, end)
