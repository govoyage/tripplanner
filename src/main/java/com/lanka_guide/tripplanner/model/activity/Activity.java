package com.lanka_guide.tripplanner.model.activity;

import java.time.ZonedDateTime;

public class Activity {
    ZonedDateTime from;
    ZonedDateTime to;

    public Activity(ZonedDateTime from, ZonedDateTime to) {
        this.from = from;
        this.to = to;
    }
}
