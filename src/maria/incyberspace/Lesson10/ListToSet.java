package maria.incyberspace.Lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ListToSet {
    public static void main(String[] args) {
        // Instantiate and initialize a new list of integers
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            integers.add(i); // Add five numbers to the list
        }
        // Add some duplicates to the list
        integers.add(1);
        integers.add(2);
        // Create a set based on the list of integers
        Set<Integer> newSet = convertListToSet(integers);
        // See that there aren't any duplicates in the set
        System.out.println(Arrays.toString(newSet.toArray()));
    }

    public static Set<Integer> convertListToSet(List<Integer> list) throws NullPointerException {
        return Set.copyOf(list);
    }
}
