package com.lanka_guide.tripplanner.model.activity.stay;

import com.lanka_guide.tripplanner.model.place.accommodation.Hotel;

import java.time.ZonedDateTime;

public class HotelStay extends Stay {
    Hotel hotel;

    public HotelStay(Hotel hotel, ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
        this.hotel = hotel;
    }

}
