package com.lanka_guide.tripplanner;

import com.lanka_guide.tripplanner.model.Itinerary;
import com.lanka_guide.tripplanner.model.activity.Activity;
import com.lanka_guide.tripplanner.model.activity.Visit;
import com.lanka_guide.tripplanner.model.activity.transport.method.drive.RentalCar;
import com.lanka_guide.tripplanner.model.place.Place;
import com.lanka_guide.tripplanner.model.place.accommodation.Hotel;
import com.lanka_guide.tripplanner.model.activity.stay.HotelStay;
import com.lanka_guide.tripplanner.model.activity.stay.Stay;
import com.lanka_guide.tripplanner.model.activity.transport.Transport;
import com.lanka_guide.tripplanner.model.activity.transport.method.Flight;
import com.lanka_guide.tripplanner.model.activity.transport.method.drive.Drive;
import com.lanka_guide.tripplanner.model.place.transport.Airport;
import com.lanka_guide.tripplanner.model.activity.transit.FlightTransit;
import com.lanka_guide.tripplanner.model.activity.transit.Transit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripApplicationTests {

    @Test
    public void testModel() {
        Itinerary itinerary = new Itinerary();

        ZoneId jakartaTimeZone = ZoneId.of("Asia/Jakarta");
        ZoneId tokyoTimeZone = ZoneId.of("Asia/Tokyo");

        Airport cts = new Airport("CTS");
        Airport hnd = new Airport("HND");
        Airport cgk = new Airport("CGK");
        Airport yog = new Airport("YOG");
        Airport sub = new Airport("SUB");

        Flight ctsToHnd = new Flight(cts, hnd, "NH85",
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(20, 00), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(22, 00), tokyoTimeZone));

        Transit hndTransit = new FlightTransit(hnd,
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(22, 00), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(23, 00), tokyoTimeZone));

        Flight hndToCgk = new Flight(hnd, cgk, "NH872",
                ZonedDateTime.of(LocalDate.of(2017, 8, 5), LocalTime.of(23, 00), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(7, 00), jakartaTimeZone));

        Transit cgkTransit = new FlightTransit(cgk,
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(7, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(10, 00), jakartaTimeZone));

        Flight cgkToYog = new Flight(cgk, yog, "GA838",
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(10, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(12, 00), jakartaTimeZone));


        Drive yogToRoyalHotel = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(13, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(14, 00), jakartaTimeZone));

        Hotel royalHotel = new Hotel("Royal Ambarrukmo");

        Stay royalHotelStay1 = new HotelStay(royalHotel,
                ZonedDateTime.of(LocalDate.of(2017, 8, 6), LocalTime.of(14, 00), jakartaTimeZone)
                , ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(7, 00), jakartaTimeZone));

        Place borobudur = new Place("Borobudur");
        Drive royalHotelToBorobudur = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(7, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(10, 00), jakartaTimeZone));

        Activity visitBorobudur = new Visit(borobudur, ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(10, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(12, 00), jakartaTimeZone));

        Place merapi = new Place("Merapi");
        Drive borobudurToMerapi = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(12, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(14, 00), jakartaTimeZone));

        Activity visitMerapi = new Visit(borobudur, ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(14, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(16, 00), jakartaTimeZone));

        Drive merapiToRoyalHotel = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(16, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(18, 00), jakartaTimeZone));

        Stay royalHotelStay2 = new HotelStay(royalHotel,
                ZonedDateTime.of(LocalDate.of(2017, 8, 7), LocalTime.of(18, 00), jakartaTimeZone)
                , ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(7, 00), jakartaTimeZone));

        Drive royalHotelToDieng = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(7, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(12, 00), jakartaTimeZone));

        Activity visitDieng = new Visit(borobudur, ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(12, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(16, 00), jakartaTimeZone));

        Drive diengToRoyalHotel = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(16, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(20, 00), jakartaTimeZone));

        Stay royalHotelStay3 = new HotelStay(royalHotel,
                ZonedDateTime.of(LocalDate.of(2017, 8, 8), LocalTime.of(20, 00), jakartaTimeZone)
                , ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(7, 00), jakartaTimeZone));

        Drive royalHotelToYog = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(7, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(8, 00), jakartaTimeZone));

        Flight yogToSub = new Flight(yog, sub, "GA890",
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(9, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(11, 00), jakartaTimeZone));

        Drive subToJiwaHotel = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(12, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(20, 00), jakartaTimeZone));

        Hotel jiwaHotel = new Hotel("Jiwa Jawa Resort");

        Stay jiwaHotelStay1 = new HotelStay(jiwaHotel,
                ZonedDateTime.of(LocalDate.of(2017, 8, 9), LocalTime.of(14, 00), jakartaTimeZone)
                , ZonedDateTime.of(LocalDate.of(2017, 8, 10), LocalTime.of(7, 00), jakartaTimeZone));

        Activity visitBromo = new Visit(borobudur, ZonedDateTime.of(LocalDate.of(2017, 8, 10), LocalTime.of(8, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 10), LocalTime.of(14, 00), jakartaTimeZone));

        Stay jiwaHotelStay2 = new HotelStay(jiwaHotel,
                ZonedDateTime.of(LocalDate.of(2017, 8, 10), LocalTime.of(14, 00), jakartaTimeZone)
                , ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(7, 00), jakartaTimeZone));

        Drive jiwaHotelToSub = new RentalCar(ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(8, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(15, 00), jakartaTimeZone));

        Flight subToCgk = new Flight(sub, cgk, "GA875",
                ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(16, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(18, 00), jakartaTimeZone));

        Hotel airportHotel = new Hotel("Jakarta Airport Hotel");
        Stay airportHotelStay = new HotelStay(airportHotel,
                ZonedDateTime.of(LocalDate.of(2017, 8, 11), LocalTime.of(18, 00), jakartaTimeZone)
                , ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(6, 00), jakartaTimeZone));

        Flight cgkToHnd = new Flight(cgk, hnd, "NH873",
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(7, 00), jakartaTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(18, 00), tokyoTimeZone));

        Transit hndTransit2 = new FlightTransit(hnd,
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(18, 00), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(19, 00), tokyoTimeZone));


        Flight hndToCts = new Flight(cts, hnd, "NH88",
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(19, 00), tokyoTimeZone),
                ZonedDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(21, 00), tokyoTimeZone));



    }

}
