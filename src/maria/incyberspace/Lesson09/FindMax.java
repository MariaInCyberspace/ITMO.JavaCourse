package maria.incyberspace.Lesson09;

public class FindMax {
    public static void main(String[] args) {
        // Instantiate and populate an array of arrays of integers
        int[][] sampleArray = {
                { 3, 5, 2, -2 },
                { 2, -9, 2, 7 }
        };
        // Find the greatest number in this matrix
        int max = findMaxIn(sampleArray);
        System.out.println(max);

    }

    public static int findMaxIn(int[][] array) throws NullPointerException {
        int max = 0; // A variable that's going to hold the maximum value found
        for (int[] ints : array) { // Iterate over the elements in this array of arrays
            try {
                for (int j = 1; j < ints.length; j++) { // Inner loops looks at elements in inner arrays
                    if (ints[j] > ints[j - 1] && ints[j] > max) { // Check whether the next element is greater and if its value is greater than that of the max variable
                        max = ints[j]; // Update the max variable
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return max;
    }
}
