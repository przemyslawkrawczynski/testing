package pl.pk.testing.qc.collections.adv.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolDirectory {

    public static void main(String[] args) {
        Principal p1 = new Principal("Jan Kowalski");
        Principal p2 = new Principal("Czesław Niemen");
        Principal p3 = new Principal("Zofia Bieniuk");

        School s1 = new School("Jedynka", 30,25,34,36);
        School s2 = new School("Dwojka",31,32,45,19);
        School s3 = new School("Trójka",30,29,34,34);

        Map<Principal, School> resultMap = new HashMap<>();

        resultMap.put(p1, s1);
        resultMap.put(p2, s2);
        resultMap.put(p3, s3);

        for (Map.Entry<Principal, School> entry: resultMap.entrySet()) {
            String principalName = entry.getKey().getPrincipalName();
            String schoolName = entry.getValue().getName();
            Integer numOfStudents = countStudents(entry.getValue().getStudentsNumber());

            System.out.println("Principal: " + principalName + " manage school: " + schoolName + " | Total students in school: " + numOfStudents);

        }

    }

    private static Integer countStudents(List<Integer> studentsInClass) {
        return studentsInClass.stream().reduce(0, Integer::sum);
    }
}
