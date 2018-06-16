package com.lanka_guide.tripplanner.model.activity.transport.method;

import java.time.ZonedDateTime;

public class Walk extends TransportMethod {
    public Walk(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
