package com.fandoco.tripplanner

import org.junit.jupiter.api.Test

class TripApplicationTests {

    @Test
    fun testSimpleItinerary() {
        print(getSimpleItinerary())
    }

    @Test
    fun testComplexItinerary() {
        print(getComplexItinerary())
    }

}