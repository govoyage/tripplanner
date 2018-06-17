package com.lankaguide.tripplanner.model.place

import com.lankaguide.tripplanner.model.Location

open class Place(open val name: String) {

     var location: Location? = null

    constructor(name: String, location: Location) : this(name) {
        this.location = location
    }

}
