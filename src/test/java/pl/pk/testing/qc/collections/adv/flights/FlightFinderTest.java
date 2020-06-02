package pl.pk.testing.qc.collections.adv.flights;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FlightFinderTest {

    private final FlightFinder finder = new FlightFinder();

    @Test
    public void findFlightsFrom() {

        //Given
        String cityFrom = "WAW";

        //When
        List<Flight> flightsFrom = finder.findFlightsFrom(cityFrom);

        //Then
        assertThat(flightsFrom.size()).isEqualTo(4);

    }

    @Test
    public void findFlightsTo() {

        //Given
        String cityFrom = "WAW";

        //When
        List<Flight> flightsFrom = finder.findFlightsTo(cityFrom);

        //Then
        assertThat(flightsFrom.size()).isEqualTo(1);

    }
}