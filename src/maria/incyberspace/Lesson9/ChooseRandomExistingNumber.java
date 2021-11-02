package maria.incyberspace.Lesson9;

import java.util.*;

public class ChooseRandomExistingNumber {
    public static void main(String[] args) {
        // Instantiate and initialize two arrays to be compared against each other
        int[] numbersArr = { 1, 2, 3, 4, 5 };
        int[] weightArr = { 7, 8, 9, 0, 2, 4, 5 };
        // Log a random number from the first array that is also present in the second one
        System.out.println(findRandomExistingNumber(numbersArr, weightArr));
    }

    public static Integer findRandomExistingNumber(int[] numbers, int[] weight) throws NullPointerException {
        // Instantiate a new array that would contain numbers present in the second array
        List<Integer> found = new ArrayList<>();
        Random random = new Random(); // To generate a random number
        Integer result = null; // 'null' if there aren't any such numbers present
        try {
            for (int number : numbers) {
                for (int i : weight) {
                    if (number == i) { // Add the number into our special array
                        found.add(number);
                    }
                }
            }
            // Store the random number out of all the duplicates in a variable
            result = found.get(random.nextInt(found.size()));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
