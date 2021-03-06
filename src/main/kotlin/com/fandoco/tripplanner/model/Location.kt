package com.fandoco.tripplanner.model

class Location(internal var mapUrl: String) {
    companion object {

        fun of(mapUrl: String): Location {
            return Location(mapUrl)
        }
    }
}
