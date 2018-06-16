package com.lanka_guide.tripplanner.model.activity.transit;

import java.time.ZonedDateTime;

public class BusTransit extends Transit {
    public BusTransit(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
