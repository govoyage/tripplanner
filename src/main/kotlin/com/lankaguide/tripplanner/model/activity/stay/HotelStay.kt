package com.lankaguide.tripplanner.model.activity.stay

import com.lankaguide.tripplanner.model.place.accommodation.Hotel

import java.time.ZonedDateTime

class HotelStay(internal var hotel: Hotel, from: ZonedDateTime, to: ZonedDateTime) : Stay(from, to)
