package maria.incyberspace.Lesson09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxRow {
    public static void main(String[] args) {
        int[][] sampleArray = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 }
        };
        System.out.println(Arrays.toString(findMaxRowIn(sampleArray)));

    }

    public static int[] findMaxRowIn(int[][] array) throws NullPointerException {
        int sum = 0; // 'Sum' variable is going to hold the value of the sum of all numbers in a row
        int maxInd = 0; // This variable will represent the index of a row which sum is the greatest in this matrix
        Map<Integer, Integer> map = new HashMap<>(); // This map will store row indexes and sums of these rows
        try {
            for (int i = 0; i < array.length; i++) { // Iterate over the matrix
                for (int j = 0; j < array[i].length; j++) { // Iterate over a row in the matrix
                    sum += array[i][j]; // Update the sum value
                }
                map.put(i, sum); // Store the index of a row and the sum of its elements in a map
            }
            // Compare values stored in the map
            for (int i = 1; i < map.size(); i++) {
                if (map.get(i).compareTo(map.get(i - 1)) > 0) {
                    maxInd = i; // Update the value of max index
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex ) {
            System.out.println(ex.getMessage());
        }
        // Find a row with a maximum sum
        return array[maxInd];
    }
}
