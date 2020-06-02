package pl.pk.testing.qc.collections.adv.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {

    private String name;
    private List<Integer> studentsNumber = new ArrayList<>();

    public School(String name, Integer... args) {
        this.name = name;
        studentsNumber.addAll(Arrays.asList(args));
    }

    public List<Integer> getStudentsNumber() {
        return studentsNumber;
    }

    public String getName() {
        return name;
    }
}
