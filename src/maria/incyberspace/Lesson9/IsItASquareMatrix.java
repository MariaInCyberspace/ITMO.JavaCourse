package maria.incyberspace.Lesson9;

public class IsItASquareMatrix {
    public static void main(String[] args) {
        // Instantiate and initialize an array of arrays of integers
        int[][] sampleArray = {
                { 2, 3, 4, 3 },
                { 3, 5, 9, 3 },
                { 3, 8, 3, 5 },
                { 3, 8, 3, 5 }
        };

        // Log the result out into the console
        System.out.println(isItASquareMatrix(sampleArray));
    }

    public static boolean isItASquareMatrix(int[][] array) throws NullPointerException {
        int rows = 0;
        int columns = 0;
        for (int[] ints : array) {
            try {
                for (int j = 1; j < ints.length; j++) {
                    columns = ints.length; // Make sure to update the columns value
                    if (ints.length != array[j].length) { // Check if the next row's size is different
                        columns = ints.length; // If the next row is indeed different in size, return
                        return false;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex.getMessage());
            }
            rows++; // Update the rows value
        }
        // Compare the values
        return rows == columns;
    }
}


