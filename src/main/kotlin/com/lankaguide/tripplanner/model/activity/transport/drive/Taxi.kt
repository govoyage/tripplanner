package com.lankaguide.tripplanner.model.activity.transport.drive

import com.lankaguide.tripplanner.model.place.Place
import java.time.ZonedDateTime

class Taxi(override val from: Place, override val to: Place, override val start: ZonedDateTime, override val end: ZonedDateTime) :
        Drive(from, to, start, end)
