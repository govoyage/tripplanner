package com.lanka_guide.tripplanner.model.activity.stay;

import com.lanka_guide.tripplanner.model.Location;
import com.lanka_guide.tripplanner.model.activity.Activity;

import java.time.ZonedDateTime;

public class Stay extends Activity {

    public Stay(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
