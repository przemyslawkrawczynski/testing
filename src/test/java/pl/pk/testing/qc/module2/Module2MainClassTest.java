package pl.pk.testing.qc.module2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Module2MainClassTest {

    @Test
    public void tesTwoThreeExercise() {
        //When
        Object[] objects = Module2MainClass.twoThreeExercise();

        //Then
        assertThat(objects[0]).isEqualTo("text");
        assertThat(objects[1]).isEqualTo(5);
        assertThat(objects[2]).isEqualTo(3L);
    }
}
