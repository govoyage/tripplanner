package com.lankaguide.tripplanner.model.activity.transport

import com.lankaguide.tripplanner.model.place.Place
import java.time.ZonedDateTime

class Bicycle(override val from: Place, override val to: Place, override val start: ZonedDateTime, override val end: ZonedDateTime)
    : Transport(from, to, start, end)
