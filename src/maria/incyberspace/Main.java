package maria.incyberspace;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Ex. 1
        System.out.println("I");
        System.out.println("know");
        System.out.println("Java");
        System.out.print("well");

        // Ex. 2
        double firstExpression = (46.0 + 10.0) * (10.0 / 3.0);
        int secondExpression = (29) * (4) * (-15);
        System.out.println("First expression: " + firstExpression);
        System.out.println("Second expression: " + secondExpression);

        // Ex. 3
        int number = 10500;
        int result = (number / 10) / 10;
        System.out.println("Here's what's stored in the 'result' variable" + result);

        // Ex. 4
        result = (int) (3.6 * 4.1 * 5.9);

        // Ex. 5
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int inputNum = scan.nextInt();
        System.out.println(inputNum);

        // Ex. 6
        System.out.println("Input another number: ");
        int b = scan.nextInt();
        if ((b % 2 == 0) && (b > 100)) {
            System.out.println("The number is out of range");
        } else if (b % 2 == 0) {
            System.out.println(b + " is an even number");
        } else {
            System.out.println(b + " is an odd number");
        }
    }
}
