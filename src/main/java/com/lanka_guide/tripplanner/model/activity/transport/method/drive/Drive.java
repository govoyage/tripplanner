package com.lanka_guide.tripplanner.model.activity.transport.method.drive;

import com.lanka_guide.tripplanner.model.activity.transport.method.TransportMethod;

import java.time.ZonedDateTime;

public class Drive extends TransportMethod {
    public Drive(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
