package Lesson3;

import java.util.Random;
import java.util.Arrays;

public class SumOfPositiveNumbers {
    public static void main(String[] args) {

        int[] randomArray = generateRandomArray();
        //int[] randomArray2 = { 2, 4, -5, 6, 7, 2, 2};
        System.out.println(Arrays.toString(randomArray));
        System.out.println("Sum of positive numbers in this array: " + sumOfPositiveNumbers(randomArray));

    }
    public static int sumOfPositiveNumbers(int[] array) {
        int sum = 0;
        for (int j : array) {
            if (j > 0) {
                sum += j;
            }
        }
        return sum;
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-100, 100);
        }
        return array;
    }
}
