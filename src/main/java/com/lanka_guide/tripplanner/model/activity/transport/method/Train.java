package com.lanka_guide.tripplanner.model.activity.transport.method;

import com.lanka_guide.tripplanner.model.place.transport.RailwayStation;

import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Train extends TransportMethod {
    RailwayStation startStation;
    RailwayStation endStation;
    LocalTime startTime;
    LocalTime endTime;

    public Train(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
