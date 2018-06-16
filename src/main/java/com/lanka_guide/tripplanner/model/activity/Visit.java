package com.lanka_guide.tripplanner.model.activity;

import com.lanka_guide.tripplanner.model.place.Place;

import java.time.ZonedDateTime;

public class Visit extends Activity {
    Place place;
    public Visit(Place place, ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
        this.place = place;
    }
}
