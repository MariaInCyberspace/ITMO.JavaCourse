package maria.incyberspace.Lesson2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {

        // Ex. 1

        // getOddNumbers(1);


        // Ex. 2

        // getNumbersDivisibleBy3And5OrBoth();


        // Ex. 3
        // System.out.println(calculateTwoInt());


        // Ex. 4
        // System.out.println(findTheLargestNumber());

        // Ex. 5
        int[] sampleArr = {3, 4, 5, 3};
        // System.out.println(is3theFirstOrLastElementOfArray(sampleArr));

        // Ex. 6
        // System.out.println(doesArrayContain1Or3(sampleArr));

    }

    // Ex. 1; A method that logs odd numbers to the console starting with the number given as a parameter and ending with 99
    public static void getOddNumbers(int input) {

        for (int i = input; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.print(i + "\t");
            }
            if (input >= 100) {
                System.out.println("Number " + input + " is out of range");
            }
        }
    }

    // Ex. 2
    public static void getNumbersDivisibleBy3And5OrBoth() {
        ArrayList<Integer> divBy3 = new ArrayList<Integer>();
        ArrayList<Integer> divBy5 = new ArrayList<Integer>();
        ArrayList<Integer> divByBoth = new ArrayList<Integer>();

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                divByBoth.add(i);
            } else if (i % 5 == 0) {
                divBy5.add(i);
            } else if (i % 3 == 0) {
                divBy3.add(i);
            }
        }
        System.out.print("Numbers divisible by 3 (total count: " + divBy3.size() + "): ");
        for (int i = 0; i < divBy3.size(); i++) {
            System.out.print(divBy3.get(i) + " ");
        }
        System.out.println(" ");
        System.out.print("Numbers divisible by 5 (total count: " + divBy5.size() + "): ");
        for (int i = 0; i < divBy5.size(); i++) {
            System.out.print(divBy5.get(i) + " ");
        }
        System.out.println(" ");
        System.out.print("Numbers divisible both by 3 and 5 (total count: " + divByBoth.size() + "): ");
        for (int i = 0; i < divByBoth.size(); i++) {
            System.out.print(divByBoth.get(i) + " ");
        }
    }


    // Ex. 3; A method that calculates the sum of two integers and returns either true or false depending on the sum being equal to the third number
    public static boolean calculateTwoInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter the third number: ");
        int thirdNumber = scanner.nextInt();

        if (firstNumber + secondNumber == thirdNumber) {
            return true;
        }
        else return false;
    }

    // Ex. 4
    public static boolean findTheLargestNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter the third number: ");
        int thirdNumber = scanner.nextInt();

        if (secondNumber > firstNumber && thirdNumber > secondNumber) {
            return true;
        }
        else return false;
    }

    // Ex. 5
    public static boolean is3theFirstOrLastElementOfArray(int[] array) {
        if (array[0] == 3 || array[array.length -1] == 3) {
            return true;
        } else return false;
    }

    // Ex. 6
    public static boolean doesArrayContain1Or3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 || array[i] == 3) {
                return true;
            }
        }
        return false;
    }

}
