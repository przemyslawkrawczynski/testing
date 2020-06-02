package pl.pk.testing.qc.collections.adv.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightFinder {

    private final FlightRepository flightRepository = new FlightRepository();

    public List<Flight> findFlightsFrom(String departure) {
        Map<String, List<Flight>> flightsTable = flightRepository.getFlightsFromTable();

        if (flightsTable.get(departure) != null) return flightsTable.get(departure);

        return new ArrayList<>();
    }

    public List<Flight> findFlightsTo(String arrival) {
        Map<String, List<Flight>> flightsTable = flightRepository.getFlightsToTable();

        if (flightsTable.get(arrival) != null) return flightsTable.get(arrival);

        return new ArrayList<>();
    }
}
