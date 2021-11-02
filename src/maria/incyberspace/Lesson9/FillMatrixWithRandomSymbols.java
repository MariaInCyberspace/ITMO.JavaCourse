package maria.incyberspace.Lesson9;

import java.util.Arrays;
import java.util.Random;

public class FillMatrixWithRandomSymbols {
    public static void main(String[] args) {
        char[][] sampleArray = new char[4][4];
        char[][] newArr = fillWithRandomCharacters(sampleArray);
        for (char[] chars : newArr) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    public static char[][] fillWithRandomCharacters(char[][] array) throws NullPointerException {
        Random random = new Random(); // Needed to generate a random number
        // An alphabet string to seed the matrix from
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        try {
            for (int i = 0; i < array.length; i++) {
                try {
                    for (int j = 0; j < array[i].length; j++) {
                        char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
                        if (Character.isDigit(randomChar)) throw new IncorrectStringException("This array shouldn't contain digits");
                        array[i][j] = randomChar; // Get a random character in the alphabet string
                    }
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }

        return array;
    }
}

class IncorrectStringException extends RuntimeException {
    public IncorrectStringException(String errorMessage) {
        super(errorMessage);
    }
}
