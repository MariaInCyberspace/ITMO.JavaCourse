package Lesson4;

public class BubbleSortPractice {

    public static void main(String[] args) {

        String[] text = {"I", "Am", "Still", "Learning", "Java", "Language"};
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i] + " ");
        }
        bubbleSort(text);
        System.out.println();
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i] + " ");
        }

        String example = "I";
        String example2 = "Am";
        if (example.compareTo(example2) > 0) {
            System.out.println(example + " is greater than " + example2);
        } else {
            System.out.println(example + " is less than " + example2);
        }

    }

    public static void bubbleSort(String[] array) {
        int length = array.length;
        String temporary;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    // Swap the values
                    temporary = new String();
                    temporary = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temporary;
                }
            }
        }
    }
}


