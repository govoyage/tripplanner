package com.lanka_guide.tripplanner.model.activity.transport;

import com.lanka_guide.tripplanner.model.Location;
import com.lanka_guide.tripplanner.model.activity.Activity;

import java.time.ZonedDateTime;
import java.util.List;

public class Transport extends Activity {
    Location startLocation;
    Location endLocation;

    public Transport(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
