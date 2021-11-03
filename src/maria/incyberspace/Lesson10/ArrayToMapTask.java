package maria.incyberspace.Lesson10;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


public class ArrayToMapTask {

    public static void main(String[] args) {
        // Instantiate and initialize a new array of integers
        Integer[] integerArr = new Integer[] { 2, 4, 4, 4, 5, 6, 6};
        // Create a new map based on the array of integers created just above by calling 'generateMapFromArray' method
        Map<Integer, Integer> newMap = generateMapFromArray(integerArr);
        System.out.println(newMap);
    }


    public static <K> Map<K, Integer> generateMapFromArray(K[] array) {
        // Instantiate and initialize a new HashMap with a generic as a key and Integer as value
        Map<K, Integer> map = new HashMap<>();
        // Iterate over the array
        for (K k : array) {
            // Populate the map with the value of K object and number of times it occurs in this array calculated by a method 'findNumberOfOccurrences'
            map.put(k, findNumberOfOccurrences(array, k));
        }
        return map;
    }

    // This method returns how many times a certain value occurs in the array passed as an argument
    public static <K> Integer findNumberOfOccurrences(K[] array, K value) {
        int count = 0;
        // Iterate over the array
        for (K k : array) {
            if (k == value) { // If there's a match, update the count value
                count++;
            }
        }
        // Will return zero if there are no such elements
        return count;
    }
}

