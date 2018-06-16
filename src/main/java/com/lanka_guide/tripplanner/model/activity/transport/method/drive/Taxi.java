package com.lanka_guide.tripplanner.model.activity.transport.method.drive;

import java.time.ZonedDateTime;

public class Taxi extends Drive {
    public Taxi(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
