package com.lanka_guide.tripplanner.model.activity.transit;

import com.lanka_guide.tripplanner.model.activity.Activity;
import com.lanka_guide.tripplanner.model.place.transport.TransportNode;

import java.time.ZonedDateTime;

public class Transit extends Activity {
    private TransportNode transportNode;

    public Transit(ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
    }
}
