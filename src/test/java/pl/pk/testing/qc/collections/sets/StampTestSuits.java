package pl.pk.testing.qc.collections.sets;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class StampTestSuits {

    @Test
    public void should_can_t_add_multiple_the_same_objects_to_HashSet() {

        //Given
        Stamp stamp1 = new Stamp("S1", 100.0, 100.0, true);
        Stamp stamp2 = new Stamp("S1", 100.0, 100.0, true);

        Set<Stamp> stampSet = new HashSet<>();

        //When
        stampSet.add(stamp1);
        stampSet.add(stamp1);
        stampSet.add(stamp2);


        //Then
        int expectedSize = 1;
        assertThat(stampSet.size()).isEqualTo(expectedSize);
        assertThat(stampSet.contains(stamp1)).isTrue();
        assertThat(stampSet.contains(stamp2)).isTrue();

    }
}
