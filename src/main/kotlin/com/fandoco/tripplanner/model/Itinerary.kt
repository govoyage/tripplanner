package com.fandoco.tripplanner.model

import java.util.*

class Itinerary(val id : String, val activities: TreeSet<Activity>) {
    override fun toString(): String {
        val sb = StringBuilder()
        for (activity in activities) {
            sb.append(activity).append("\n")
        }
        return sb.toString()
    }
}