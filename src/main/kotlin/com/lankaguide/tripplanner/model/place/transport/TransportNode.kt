package com.lankaguide.tripplanner.model.place.transport

import com.lankaguide.tripplanner.model.Location
import com.lankaguide.tripplanner.model.place.Place

open class TransportNode : Place {

    constructor(name: String, location: Location) : super(name, location) {}

    constructor(name: String) : super(name) {}

}
