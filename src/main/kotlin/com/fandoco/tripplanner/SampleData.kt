package com.fandoco.tripplanner

import com.fandoco.tripplanner.model.Activity
import com.fandoco.tripplanner.model.Itinerary
import com.fandoco.tripplanner.model.Location
import com.fandoco.tripplanner.model.Place
import java.time.*
import java.util.*

val tokyoTimeZone = ZoneId.of("Asia/Tokyo")

fun getSimpleItinerary() : Itinerary {
    val activities = TreeSet<Activity>()
    val home = Place("/stay/home", "Home", Location.of("https://goo.gl/maps/asftDEHjBMR2"))
    val nikko = Place("/attraction", "Nikko")

    val startTime = ZonedDateTime.of(LocalDate.of(2018, 6, 5), LocalTime.of(8, 30), tokyoTimeZone)

    val homeToNikko = Activity("/transport/drive/ownCar", "Drive to Niko", startTime,
            startTime.plusHours(4), home, nikko)

    val visitNikko = Activity("/visit", "Visit Nikko", homeToNikko.endTime, Duration.ofHours(3),
            nikko)

    val nikkoToHome =  Activity("/transport/drive/ownCar", "Drive Home", visitNikko.endTime,
            visitNikko.endTime.plusHours(4), nikko, home)

    activities.add(homeToNikko)
    activities.add(visitNikko)
    activities.add(nikkoToHome)

    return Itinerary("1", activities)
}

fun getComplexItinerary(): Itinerary {
    val activities = TreeSet<Activity>()

    val jakartaTimeZone = ZoneId.of("Asia/Jakarta")

    val home = Place("/stay/home", "Home", Location.of("https://goo.gl/maps/asftDEHjBMR2"))
    val cts = Place("/stay/home", "CTS", Location.of("https://goo.gl/maps/asftDEHjBMR2"))
    val hnd = Place("/transport/airport", "HND")
    val cgk = Place("/transport/airport", "CGK")
    val yog = Place("/transport/airport", "JOG", Location.of("https://goo.gl/maps/3ujjHmAfKJR2"))
    val sub = Place("/transport/airport", "SUB", Location.of("https://goo.gl/maps/YefXqzpwWVt"))

    val ctsToHnd = Activity("/transport/flight/domestic", "CTS to HND Flight",
            ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(20, 30), tokyoTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(22, 5), tokyoTimeZone),
            cts, hnd)
    ctsToHnd.addAttribute("FLIGHT_NUMBER", "NH85")

    activities.add(ctsToHnd)

    val ctsToHndEp = Activity("/transport/flight/domConToIntEP", "CTS to HND EP",
            ctsToHnd.startTime.minus(Duration.ofHours(1).plusMinutes(30)),
            ctsToHnd.startTime, cts, cts)

    activities.add(ctsToHndEp)

    val homeToCTS = Activity("/transport/drive/ownCar", "Drive to CTS",
            ctsToHndEp.startTime.minus(Duration.ofHours(2).plusMinutes(30)),
            ctsToHndEp.startTime, home, cts)

    activities.add(homeToCTS)

    val ctsToHndDP = Activity("/transport/flight/domConToIntDP", "CTS to HND DP", ctsToHnd.endTime,
            ctsToHnd.endTime.plus(Duration.ofMinutes(30)), hnd, hnd)

    activities.add(ctsToHndDP)

    val hndToCgk = Activity("/transport/flight/international", "HND to CGK",
            ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(23, 30), tokyoTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(5, 5), jakartaTimeZone),
            hnd, cgk)
    ctsToHnd.addAttribute("FLIGHT_NUMBER", "NH871")

    activities.add(hndToCgk)

    val hndToCgkEP = Activity("/transport/flight/intConFromDomEP", "HND to CGK EP",
            hndToCgk.startTime.minus(Duration.ofMinutes(40)), hndToCgk.startTime, hnd)

    activities.add(hndToCgkEP)

    val hndToCgkTransit = Activity("/transport/flight/transit", "HND Transit 1", ctsToHndDP.endTime, hndToCgkEP
            .startTime, hnd)

    activities.add(hndToCgkTransit)

    val hndToCgkDP = Activity("/transport/flight/internationalDP", "HND to CGK DP", hndToCgk.endTime,
            hndToCgk.endTime.plus(Duration.ofMinutes(40)), cgk)

    activities.add(hndToCgkDP)

    val cgkToYog = Activity("/transport/flight/domestic", "CGK to YOG Flight",
            ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(10, 5), jakartaTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(11, 20), jakartaTimeZone),
            cgk, yog)
    cgkToYog.addAttribute("FLIGHT_NUMBER", "GA206")

    activities.add(cgkToYog)

    val cgkToYogEP = Activity("/transport/flight/domesticEP", "CGK to YOG EP",
            cgkToYog.startTime.minus(Duration.ofHours(1)), cgkToYog.startTime, cgk)

    activities.add(cgkToYogEP)

    val cgkToYogTransit = Activity("/transport/flight/transit", "CGK Transit 1", hndToCgkDP.endTime, cgkToYogEP
            .startTime, cgk)

    activities.add(cgkToYogTransit)

    val cgkToYogDP = Activity("/transport/flight/domesticDP", "CGK to YOG DP", cgkToYog.endTime,
            cgkToYog.endTime.plus(Duration.ofMinutes(30)), yog)

    activities.add(cgkToYogDP)

    val royalHotel = Place("/stay/hotel", "Royal Ambarrukmo", Location.of("https://goo.gl/maps/E8KfcV1Efyy"))

    val yogToRoyalHotel = Activity("/transport/drive/rentalCar", "Drive from YOG to Hotel", cgkToYogDP.endTime,
            cgkToYogDP.endTime.plus(Duration.ofMinutes(30)), yog, royalHotel)

    activities.add(yogToRoyalHotel)

    val royalHotelStay1 = Activity("/stay/hotel", "Royal Hotel Stay Day 1", yogToRoyalHotel.endTime,
            ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(7, 0), jakartaTimeZone),
            royalHotel)

    activities.add(royalHotelStay1)

    val borobudur = Place("/attraction", "Borobudur")

    val royalHotelToBorobudur = Activity("/transport/drive/rentalCar", "Drive to Borobudur", royalHotelStay1
            .endTime,
            Duration.ofHours(2), royalHotel, borobudur)

    activities.add(royalHotelToBorobudur)

    val visitBorobudur = Activity("/visit", "Visit Borobudur", royalHotelToBorobudur.endTime, Duration.ofHours(3),
            borobudur)

    activities.add(visitBorobudur)

    val merapi = Place("/attraction", "Merapi")

    val borobudurToMerapi = Activity("/transport/drive/rentalCar", "Drive to Merapi", visitBorobudur.endTime,
            Duration
                    .ofHours(2), borobudur, merapi)

    activities.add(borobudurToMerapi)

    val visitMerapi = Activity("/visit", "Visit Merapi", borobudurToMerapi.endTime, Duration.ofHours(3), merapi)

    activities.add(visitMerapi)

    val merapiToRoyalHotel = Activity("/transport/drive/rentalCar", "Drive from Merapi to Royal Hotel", visitMerapi
            .endTime,
            Duration
                    .ofHours(2), merapi, royalHotel)

    activities.add(merapiToRoyalHotel)

    val royalHotelStay2 = Activity("/stay/hotel", "Royal Hotel Stay Day 2",
            merapiToRoyalHotel.endTime,
            ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(7, 0),
                    jakartaTimeZone), royalHotel)

    activities.add(royalHotelStay2)

    val dieng = Place("/attraction", "Dieng")

    val royalHotelToDieng = Activity("/transport/drive/rentalCar", "Royal Hotel to Dieng", royalHotelStay2.endTime,
            Duration
                    .ofHours(4), royalHotel, dieng)

    activities.add(royalHotelToDieng)

    val visitDieng = Activity("/visit", "Visit Dieng", royalHotelToDieng.endTime, Duration.ofHours(5), dieng)

    activities.add(visitDieng)

    val diengToRoyalHotel = Activity("/transport/drive/rentalCar", "Dieng to Royal Hotel", visitDieng.endTime,
            Duration
                    .ofHours
                    (4), dieng, royalHotel)

    activities.add(diengToRoyalHotel)

    val yogToCgk = Activity("/transport/flight/domestic", "Yog to CGK",
            ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(7, 20), jakartaTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(8, 40), jakartaTimeZone), yog, sub)
    cgkToYog.addAttribute("FLIGHT_NUMBER", "GA203")

    activities.add(yogToCgk)

    val yogToCgkEP = Activity("/transport/flight/domesticEP", "YOG to CGK EP", Duration.ofHours(1).plusMinutes(30),
            yogToCgk
                    .startTime, yog)

    activities.add(yogToCgkEP)

    val royalHotelToYog = Activity("/transport/drive/rentalCar", "Royal Hotel to YOG", Duration.ofMinutes(30),
            yogToCgkEP.startTime,
            royalHotel, yog)

    activities.add(royalHotelToYog)

    val royalHotelStay3 = Activity("/stay/hotel", "Roya Hotel Stay Day 3", diengToRoyalHotel.endTime,
            royalHotelToYog.startTime,
            royalHotel)

    activities.add(royalHotelStay3)

    val yogToCgkDP = Activity("/transport/flight/domesticDP", "YOG to CGK DP", yogToCgk.endTime, Duration.ofMinutes
    (30), cgk)

    activities.add(yogToCgkDP)

    val cgkToSub = Activity("/transport/flight/domestic", "CGK to SUB Flight",
            ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(12, 50), jakartaTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(14, 30), jakartaTimeZone),
            yog, sub)
    cgkToYog.addAttribute("FLIGHT_NUMBER", "GA314")

    activities.add(cgkToSub)

    val cgkToSubEP = Activity("/transport/flight/domesticEP", "CGK to SUB EP", Duration.ofHours(1).plusMinutes
    (30), cgkToSub
            .startTime, yog)

    activities.add(cgkToSubEP)

    val cgkToSubTransit = Activity("/transport/flight/transit", "CGK Transit 2", yogToCgkDP.endTime, cgkToSubEP
            .startTime, cgk)

    activities.add(cgkToSubTransit)

    val cgkToSubDP = Activity("/transport/flight/domesticDP", "CGK to SUB DP", cgkToSub.endTime, Duration
            .ofMinutes(30), sub)

    activities.add(cgkToSubDP)

    val jiwaHotel = Place("/stay/hotel", "Jiwa Jawa Resort", Location.of("https://goo.gl/maps/vDT9gyK5AZp"))

    val subToJiwaHotel = Activity("/transport/drive/rentalCar", "SUB to Jiwa Hotel", cgkToSubDP.endTime, Duration
            .ofHours(5), sub, jiwaHotel)

    activities.add(subToJiwaHotel)

    val bromo = Place("/attraction", "Bromo")

    val jiwaHotelStay1 = Activity("/stay/hotel", "Jiwa Hotel Stay 1", subToJiwaHotel.endTime,
            ZonedDateTime.of(LocalDate.of(2017, 8, 10), LocalTime.of(7, 0), jakartaTimeZone), jiwaHotel)

    activities.add(jiwaHotelStay1)

    val visitBromo = Activity("/visit", "Visit Bromo", jiwaHotelStay1.endTime, Duration.ofHours(8), bromo)

    activities.add(visitBromo)

    val jiwaHotelStay2 = Activity("/stay/hotel", "Jiwa Hotel Stay 2", visitBromo.endTime,
            ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(7, 0), jakartaTimeZone), jiwaHotel)

    activities.add(jiwaHotelStay2)

    val jiwaHotelToSub = Activity("/transport/drive/rentalCar", "Jiwa Hotel to Sub", jiwaHotelStay2.endTime,
            Duration
                    .ofHours(5), jiwaHotel, sub)

    activities.add(jiwaHotelToSub)

    val subToCgk = Activity("/transport/flight/domestic", "SUB to CGK Flight",
            ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(18, 0), jakartaTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(19, 20), jakartaTimeZone),
            sub, cgk)
    cgkToYog.addAttribute("FLIGHT_NUMBER", "GA323")

    activities.add(subToCgk)

    val subToCgkEP = Activity("/transport/flight/domesticEP", "SUB to CGK EP", Duration.ofHours(1).plusMinutes(30)
            , subToCgk.startTime, sub)

    activities.add(subToCgkEP)

    val subShopping = Activity("/shopping", "Surabaya Shopping", jiwaHotelToSub.endTime, subToCgkEP.startTime, sub)

    activities.add(subShopping)

    val subCgkDP = Activity("/transport/flight/domesticDP", "SUB to CGK DP", subToCgk.endTime, Duration.ofMinutes
    (30), cgk)

    activities.add(subCgkDP)

    val airportHotel = Place("/stay/hotel", "Jakarta Airport Hotel", Location.of("https://goo.gl/maps/Mu6gJAShUTA2"))

    val cgkToHnd = Activity("/transport/flight/international", "CGK to HND Flight",
            ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(7, 10), jakartaTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(16, 25), tokyoTimeZone),
            cgk, hnd)
    cgkToYog.addAttribute("FLIGHT_NUMBER", "NH872")

    activities.add(cgkToHnd)

    val cgkToHndEP = Activity("/transport/flight/internationalEP", "CGK to HND EP", cgkToHnd.startTime.minus
    (Duration.ofHours(2)
            .plusMinutes(30)), cgkToHnd.startTime, cgk)

    activities.add(cgkToHndEP)

    val airportHotelStay = Activity("/stay/hotel", "Airport Hotel Stay", subCgkDP.endTime, cgkToHndEP.startTime,
            airportHotel)

    activities.add(airportHotelStay)

    val cgkToHndDP = Activity("/transport/flight/intConToDomDP", "CGK to HND DP", cgkToHnd.endTime,
            cgkToHnd.endTime.plus(Duration.ofMinutes(40)), hnd)

    activities.add(cgkToHndDP)

    val hndToCts = Activity("/transport/flight/domestic", "HND to CTS Flight",
            ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(18, 0), tokyoTimeZone),
            ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(19, 30), tokyoTimeZone),
            cts, hnd)
    cgkToYog.addAttribute("FLIGHT_NUMBER", "NH75")

    activities.add(hndToCts)

    val hndToCtsEP = Activity("/transport/flight/domConFromIntEP", "HND to CTS EP", Duration.ofMinutes(30), hndToCts
            .startTime, hnd)

    activities.add(hndToCtsEP)

    val hndToCtsTransit = Activity("/transport/flight/transit", "HND to CTS transit HND", cgkToHndDP.endTime,
            hndToCtsEP
                    .startTime, hnd)

    activities.add(hndToCtsTransit)

    val hndToCtsDP = Activity("/transport/flight/domesticDP", "HND to CTS DP", hndToCts.endTime, Duration.ofHours
    (1), cgk)

    activities.add(hndToCtsDP)

    val ctsToHome = Activity("/transport/drive/ownCar", "Drive Home",
            hndToCtsDP.endTime, Duration.ofHours(2).plusMinutes(30), cts, home)

    activities.add(ctsToHome)

    return Itinerary("2", activities)
}