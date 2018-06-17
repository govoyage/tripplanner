package com.lankaguide.tripplanner.model.activity.transport

import com.lankaguide.tripplanner.model.activity.Activity
import com.lankaguide.tripplanner.model.place.Place

import java.time.ZonedDateTime

abstract class Transport(open val from: Place, open val to: Place, override val start: ZonedDateTime, override val end: ZonedDateTime) : Activity(start, end)