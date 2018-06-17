package com.lanka_guide.tripplanner

import com.lankaguide.tripplanner.model.Itinerary
import com.lankaguide.tripplanner.model.Location
import com.lankaguide.tripplanner.model.activity.Activity
import com.lankaguide.tripplanner.model.activity.Visit
import com.lankaguide.tripplanner.model.activity.stay.HotelStay
import com.lankaguide.tripplanner.model.activity.transit.FlightTransit
import com.lankaguide.tripplanner.model.activity.transport.drive.OwnCar
import com.lankaguide.tripplanner.model.activity.transport.drive.RentalCar
import com.lankaguide.tripplanner.model.activity.transport.flight.*
import com.lankaguide.tripplanner.model.place.Place
import com.lankaguide.tripplanner.model.place.accommodation.Home
import com.lankaguide.tripplanner.model.place.accommodation.Hotel
import com.lankaguide.tripplanner.model.place.transport.Airport
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import java.time.*

//@RunWith(SpringRunner::class)
//@SpringBootTest
class TripApplicationTests {

//    @Test
    fun testModel() {
        val itinerary = Itinerary()

        val jakartaTimeZone = ZoneId.of("Asia/Jakarta")
        val tokyoTimeZone = ZoneId.of("Asia/Tokyo")

        val home = Home("Home", Location.of("https://goo.gl/maps/asftDEHjBMR2"))
        val cts = Airport("CTS", Location.of("https://goo.gl/maps/asftDEHjBMR2"))
        val hnd = Airport("HND")
        val cgk = Airport("CGK")
        val yog = Airport("JOG", Location.of("https://goo.gl/maps/3ujjHmAfKJR2"))
        val sub = Airport("SUB", Location.of("https://goo.gl/maps/YefXqzpwWVt"))

        val ctsToHnd = Flight(cts, hnd, "NH85",
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(20, 30), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(22, 5), tokyoTimeZone),
                Flight.Type.DOMESTIC, Flight.Connection(Flight.Type.INTERNATIONAL))

        val ctsToHndEp = DomConToIntEP(cts, ctsToHnd.depature)

        val homeToCTS = OwnCar(home, cts, ctsToHndEp.start.minus(Duration.ofHours(2).plusMinutes(30)), ctsToHndEp.start)

        val ctsToHndDP = DomConToIntDP(hnd, ctsToHnd.arrival)

        val hndToCgk = Flight(hnd, cgk, "NH871",
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(23, 30), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(5, 5), jakartaTimeZone),
                Flight.Type.INTERNATIONAL)

        val hndToCgkEP = IntConFromDomEP(hnd, hndToCgk.depature)
        val hndToCgkTransit = FlightTransit(hnd, ctsToHndDP.end, hndToCgkEP.start)

        val hndToCgkDP = InternationalDP(cgk, hndToCgk.arrival)

        val cgkToYog = Flight(cgk, yog, "GA206",
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(10, 5), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(11, 20), jakartaTimeZone),
                Flight.Type.DOMESTIC)

        val cgkToYogEP = DomesticEP(yog, cgkToYog.depature)

        val cgkToYogTransit = FlightTransit(cgk, hndToCgkDP.end, cgkToYogEP.start)

        val cgkToYogDP = DomesticDP(yog, cgkToYog.arrival)

        val royalHotel = Hotel("Royal Ambarrukmo", Location.of("https://goo.gl/maps/E8KfcV1Efyy"))

        val yogToRoyalHotel = RentalCar(yog , royalHotel, cgkToYogDP.end, Duration.ofMinutes(30))

        val royalHotelStay1 = HotelStay(royalHotel, yogToRoyalHotel.end,
                ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(7, 0), jakartaTimeZone))

        val borobudur = Place("Borobudur")

        val royalHotelToBorobudur = RentalCar(royalHotel, borobudur, royalHotelStay1.end, Duration.ofHours(2))

        val visitBorobudur = Visit(borobudur, royalHotelToBorobudur.end, Duration.ofHours(3))

        val merapi = Place("Merapi")

        val borobudurToMerapi = RentalCar(borobudur, merapi, visitBorobudur.end, Duration.ofHours(2))

        val dieng = Place("Dieng")

        val visitMerapi = Visit(merapi, borobudurToMerapi.end, Duration.ofHours(3))

        val merapiToRoyalHotel = RentalCar(borobudur, merapi, visitBorobudur.end, Duration.ofHours(2))

        val royalHotelStay2 = HotelStay(royalHotel,
                merapiToRoyalHotel.end, ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(7, 0), jakartaTimeZone))

        val royalHotelToDieng = RentalCar(royalHotel, dieng, royalHotelStay2.end, Duration.ofHours(4))

        val visitDieng = Visit(dieng, royalHotelToDieng.end, Duration.ofHours(5))

        val diengToRoyalHotel = RentalCar(dieng, royalHotel, visitDieng.end, Duration.ofHours(4))


        val yogToCgk = Flight(yog, sub, "GA203",
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(7, 20), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(8, 40), jakartaTimeZone),
                Flight.Type.DOMESTIC)

        val yogToCgkEP = DomesticEP(yog, yogToCgk.depature)
        val royalHotelToYog = RentalCar(royalHotel, yog, Duration.ofMinutes(30), yogToCgkEP.start)

        val royalHotelStay3 = HotelStay(royalHotel, diengToRoyalHotel.end, royalHotelToYog.start)

        val yogToCgkDP = DomesticDP(cgk, yogToCgk.arrival)

        val cgkToSub = Flight(yog, sub, "GA314",
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(12, 50), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(14, 30), jakartaTimeZone),
                Flight.Type.DOMESTIC)

        val cgkToSubEP = DomesticEP(yog, cgkToSub.depature)

        val cgkToSubTransit = FlightTransit(cgk, cgkToYogDP.end, cgkToSubEP.start)

        val cgkToSubDP = DomesticDP(sub, cgkToSub.arrival)

        val jiwaHotel = Hotel("Jiwa Jawa Resort", Location.of("https://goo.gl/maps/vDT9gyK5AZp"))

        val subToJiwaHotel = RentalCar(sub, jiwaHotel, cgkToSubDP.end, Duration.ofHours(5))


        val bromo = Place("Bromo")

        val jiwaHotelStay1 = HotelStay(jiwaHotel, subToJiwaHotel.end,
                ZonedDateTime.of(LocalDate.of(2017, 8, 10), LocalTime.of(7, 0), jakartaTimeZone))

        val visitBromo = Visit(bromo, jiwaHotelStay1.end, Duration.ofHours(8))

        val jiwaHotelStay2 = HotelStay(jiwaHotel, visitBromo.end,
                ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(7, 0), jakartaTimeZone))

        val jiwaHotelToSub = RentalCar(jiwaHotel, sub, jiwaHotelStay2.end, Duration.ofHours(5))

        val subToCgk = Flight(sub, cgk, "GA323",
                ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(18, 0), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(19, 20), jakartaTimeZone),
                Flight.Type.DOMESTIC)

        val subToCgkEP = DomesticEP(sub, subToCgk.depature)

        val subShopping = Activity(jiwaHotelToSub.end, subToCgkEP.start)

        val subCgkDP = DomesticDP(cgk, subToCgk.arrival)

        val airportHotel = Hotel("Jakarta Airport Hotel", Location.of("https://goo.gl/maps/Mu6gJAShUTA2"))

        val cgkToHnd = Flight(cgk, hnd, "NH872",
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(7, 10), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(16, 25), tokyoTimeZone),
        Flight.Type.INTERNATIONAL, Flight.Connection(Flight.Type.DOMESTIC))

        val cgkToHndEP = InternationalEP(cgk, cgkToHnd.depature)


        val airportHotelStay = HotelStay(airportHotel, subCgkDP.end, cgkToHndEP.start)

        val cgkToHndDP = IntConToDomDP(hnd, cgkToHnd.arrival)

        val hndToCts = Flight(cts, hnd, "NH75",
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(18, 0), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(19, 30), tokyoTimeZone), Flight.Type.DOMESTIC)

        val hndToCtsEP = DomConFromIntEP(hnd, hndToCts.depature)
        hndToCtsEP.security = false

        val hndToCtsTransit = FlightTransit(hnd, cgkToHndDP.end, hndToCtsEP.start)

    }

}
