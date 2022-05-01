package homeworks;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Hw21_1 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>(Arrays.asList("A", "B", "E", "J", "F", "G"));
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList("A", "C", "E", "J", "L"));

        Set<String> union = new LinkedHashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union of: " + union);

        Set<String> difference = new LinkedHashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference of: " + difference);

        Set<String> difference2 = new LinkedHashSet<>(set2);
        difference2.removeAll(set1);
        System.out.println("Difference of: " + difference2);

        Set<String> intersection = new LinkedHashSet<>();
        for (String a: set2) {
            if (set1.contains(a))
                intersection.add(a);
        }
        System.out.println("Intersection of : " + intersection);
    }
}
