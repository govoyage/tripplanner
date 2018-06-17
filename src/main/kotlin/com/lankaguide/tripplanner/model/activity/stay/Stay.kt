package com.lankaguide.tripplanner.model.activity.stay

import com.lankaguide.tripplanner.model.activity.Activity

import java.time.ZonedDateTime

open class Stay(from: ZonedDateTime, to: ZonedDateTime) : Activity(from, to)
