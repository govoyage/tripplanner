package com.lanka_guide.tripplanner.model.activity.transit;

import com.lanka_guide.tripplanner.model.place.transport.Airport;

import java.time.ZonedDateTime;

public class FlightTransit extends Transit {
    Airport airport;

    public FlightTransit(Airport airport, ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
        this.airport = airport;
    }
}
