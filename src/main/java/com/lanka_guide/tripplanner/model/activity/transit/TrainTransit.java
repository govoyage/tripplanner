package com.lanka_guide.tripplanner.model.activity.transit;

import java.time.ZonedDateTime;

public class TrainTransit extends Transit {
    public TrainTransit(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
