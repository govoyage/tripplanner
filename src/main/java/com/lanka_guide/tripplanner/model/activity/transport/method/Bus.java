package com.lanka_guide.tripplanner.model.activity.transport.method;

import java.time.ZonedDateTime;

public class Bus extends TransportMethod {
    public Bus(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
