package pl.pk.testing.qc.collections.adv.flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightRepository {

    private final        Flight[] flights = {
            new Flight("WAW", "BRL"),
            new Flight("WAW", "WRO"),
            new Flight("WAW", "SZC"),
            new Flight("WAW", "RZE"),
            new Flight("BRL", "WAW"),
            new Flight("BRL", "WRO"),
            new Flight("RZE", "SZC"),
            new Flight("RZE", "BRL")
    };

    public Map<String, List<Flight>> getFlightsFromTable() {
       return createMapFromFlights(flights);

    }

    public Map<String, List<Flight>> getFlightsToTable() {
        return createMapToFlights(flights);
    }

    private Map<String, List<Flight>> createMapFromFlights(Flight... flights) {
        Map<String, List<Flight>> flightsTable = new HashMap<>();

        for (Flight flight : flights) {
            String flightArrival = flight.getArrival();
            if (flightsTable.containsKey(flightArrival)) {
                flightsTable.get(flightArrival).add(flight);
            } else {
                List<Flight> flightList = new ArrayList<>();
                flightList.add(flight);
                flightsTable.put(flightArrival, flightList);
            }

        }

        return flightsTable;
    }

    private Map<String, List<Flight>> createMapToFlights(Flight... flights) {
        Map<String, List<Flight>> flightsTable = new HashMap<>();

        for (Flight flight : flights) {
            String departure = flight.getDeparture();
            if (flightsTable.containsKey(departure)) {
                flightsTable.get(departure).add(flight);
            } else {
                List<Flight> flightList = new ArrayList<>();
                flightList.add(flight);
                flightsTable.put(departure, flightList);
            }

        }

        return flightsTable;
    }

}


