package com.lanka_guide.tripplanner.model.activity.transport.method;

import com.lanka_guide.tripplanner.model.place.transport.Airport;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Flight extends TransportMethod {
    Airport departureAirport;
    Airport arrivalAirport;
    String code;
    ZonedDateTime flightDepartureTime;
    ZonedDateTime flightArrivalTime;
    ZonedDateTime airportArrivalTime;
    ZonedDateTime airportDepartureTime;
    Duration duration;

    public Flight(Airport departureAirport, Airport arrivalAirport, String code, ZonedDateTime from, ZonedDateTime to) {
        super(from, to);
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.code = code;
    }
}
