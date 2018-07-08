package com.fandoco.tripplanner.model

data class Place(val type: String, val name: String) {

    var location: Location? = null

    constructor(type: String, name: String, location: Location) : this(type, name) {
        this.location = location
    }

}
