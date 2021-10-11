package maria.incyberspace;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Ex. 1
        getOddNumbers(1);


    }

    // A method that logs odd numbers to the console
    public static void getOddNumbers(int input) {

        for (int i = input; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.print(i + "\t");
            }
        }
    }
}
