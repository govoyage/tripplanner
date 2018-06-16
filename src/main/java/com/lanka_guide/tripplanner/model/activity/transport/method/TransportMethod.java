package com.lanka_guide.tripplanner.model.activity.transport.method;

import com.lanka_guide.tripplanner.model.activity.transport.Transport;

import java.time.ZonedDateTime;

public class TransportMethod extends Transport {
    public TransportMethod(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
