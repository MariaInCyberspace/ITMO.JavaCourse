package maria.incyberspace.Lesson03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercises {

    public static void main(String[] args) {

        // Ex. 1
        int[] sampleArray = { 1, 3, 1, 4, 7, 3, 4, 0 , 0, 0, 7, 6 };
         System.out.println("Is this array sorted? " + isArraySorted(sampleArray));

        // Ex. 2
         System.out.println("That's your custom array: " + Arrays.toString(getCustomArray()));

        // Ex. 3
         System.out.println("This is an initial array: " + Arrays.toString(sampleArray));
         System.out.println("That's a modified array: " + Arrays.toString(switchFirstAndLastElementsOfAnArray(sampleArray)));

        // Ex. 4
        System.out.print("Sample array: ");
        for (int i = 0; i < sampleArray.length; i++) {
            System.out.print(sampleArray[i] + ", ");
        }
        System.out.println("First unique element in this array: " + getFirstUniqueElement(sampleArray));

        // Ex. 5
        // Fibonacci
        calculateFibonacci(10);

        // Ex. 6
        Random random = new Random();
        int[] randomArray = new int[random.nextInt(10)];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(-10, 10);
        }
        sortArray(randomArray, 0, randomArray.length - 1);
        System.out.println("That's an unsorted random array: ");
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println("This is the same array but sorted: ");
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }

    }

    // Method 1:
    // Check if an array has been sorted by ascension, if true "OK", else "Please, try again"

    public static String isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // The condition checks whether currently checked element of the array is greater than the next one
            // In case such an element is found we exit the loop and return to the method that called 'isArraySorted'
            if (array[i] > array[i + 1]) {
                return "Please, try again!";
            }
        }
        return "OK!";
    }

    // Method 2:
    // A program that takes user input to get the size of an array, then user types in the numbers
    // On the next line: output the array

    public static int[] getCustomArray() {
        // Scanner object instantiation and initialization to get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("What size do you want the array to be?");
        // Save the number the user typed in
        int size = scanner.nextInt();
        // Instantiate a new array of a given size
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Input the number: ");
            // Let the user populate the array
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Method 3:
    // This method switches the first and last elements in the array passed as a parameter
    public static int[] switchFirstAndLastElementsOfAnArray(int[] array) {
        int firstElement = array[0];
        int lastElement = array[array.length - 1];
        array[0] = lastElement;
        array[array.length - 1] = firstElement;
        return array;
    }

    // Method 4:
    // This method finds the first unique element in the given array
    public static int getFirstUniqueElement(int[] array) {

        int unique = - 1;
        // To store the unique values found in the sorted array
        ArrayList<Integer> uniqueElements = new ArrayList<>();
        // To store the copy of an original array so as not to make changes to the initial one
        int[] copiedArray = new int[array.length];

        System.out.println("Unsorted: "+ Arrays.toString(array));

        // Populate the copied array
        for (int i = 0; i < array.length; i++) {
            copiedArray[i] = array[i];
        }
        // Sort the copied array
        sortArray(copiedArray, 0, copiedArray.length - 1);
        System.out.println("Sorted: " + Arrays.toString(copiedArray));

        for (int i = 1; i < copiedArray.length - 1; i++) {
            if ((copiedArray[i - 1] != copiedArray[i]) && (copiedArray[i - 1] == copiedArray[0]) && (i == 1)) { // Check if first element is unique
                uniqueElements.add(copiedArray[i - 1]);
            } else if (copiedArray[i] == copiedArray[i + 1]) { // Check if the next element has the same value
                continue;
            } else if (copiedArray[i] != copiedArray[i - 1] && copiedArray[i] != copiedArray[i + 1]) {
                uniqueElements.add(copiedArray[i]);
            } else if ((copiedArray[i + 1] != copiedArray[i]) && (copiedArray[i + 1] == copiedArray[copiedArray.length - 1])
                    && (i == copiedArray.length - 2)) { // Check if last element is unique
                uniqueElements.add(copiedArray[i + 1]);
            }

        }
        // Iterate over the original array and compare its values to the list of unique elements
        if (uniqueElements.get(0) != null) { // Check whether the list of unique elements contains at least one value
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < uniqueElements.size(); j++) {
                    if (array[i] == uniqueElements.get(j)) {
                        return unique = array[i];
                    }
                }
            }
        }

        // If there aren't any unique values in this array
        return unique;
    }

    // This method is called by the sortArray method and merges two halves of the given array
    private static void mergeArray(int[] array, int startingPoint, int middlePoint, int endingPoint) {

        int leftSize = middlePoint - startingPoint + 1;
        int rightSize = endingPoint - middlePoint;

        int LeftArray[] = new int[leftSize];
        int RightArray[] = new int[rightSize];

        for (int x = 0; x < leftSize; ++x) {
            LeftArray[x] = array[startingPoint + x];

        }

        for (int x = 0; x < rightSize; ++x) {
            RightArray[x] = array[middlePoint + 1 + x];

        }

        int leftIndex = 0;
        int rightIndex = 0;
        int originIndex = startingPoint;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (LeftArray[leftIndex] <= RightArray[rightIndex]) {
                array[originIndex] = LeftArray[leftIndex];
                leftIndex++;
            } else {
                array[originIndex] = RightArray[rightIndex];
                rightIndex++;
            }
            originIndex++;
        }
        while (leftIndex < leftSize) {
            array[originIndex] = LeftArray[leftIndex];
            leftIndex++;
            originIndex++;
        }

        while (rightIndex < rightSize) {
            array[originIndex] = RightArray[rightIndex];
            rightIndex++;
            originIndex++;
        }
    }

    // This method identifies the middle point of the given array
    private static void sortArray(int[] array, int startingPoint, int endingPoint) {
        if (startingPoint < endingPoint) {
            int middlePoint = (startingPoint + endingPoint) / 2;
            sortArray(array, startingPoint, middlePoint);
            sortArray(array, middlePoint + 1, endingPoint);
            mergeArray(array, startingPoint, middlePoint, endingPoint);
        }
    }

    // This method calculates the first 'n' in the fibonacci sequence
    public static void calculateFibonacci(int n) {
        int first = 0, second = 1;
        System.out.println("First " + n + " Fibonacci numbers: ");
        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }
}



