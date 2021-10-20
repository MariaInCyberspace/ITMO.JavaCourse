package maria.incyberspace.Lesson4;

import java.util.Locale;

public class ExercisesLesson4Strings {


    public static void main(String[] args) {

        // Ex. 1
        // Search for the longest string
        // testGetTheLongestStringMethod();

        // Ex. 2
        // Is the string a palindrome?
        // testCheckIfPalindrome();

        // Ex. 3
        // Change a substring in a string
        // testChangeSubstring();

        // Ex. 4
        // Find the number of times a certain substring occurs in a given string
        // testGetNumberOfOccurrences();

        // Ex. 5
        // Invert individual words in a given string
        // testInvertSubstrings();

    }



    // Method 1:
    // This method searches for the longest string
    public static String getTheLongestString(String[] stringArray) {
        String longest = new String();
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray.length; j++) {
                if (stringArray[i].length() > stringArray[j].length()) {
                    longest = stringArray[i];
                }
            }
        }
        return longest;
    }
    // This method tests 'getTheLongestString'
    public static void testGetTheLongestStringMethod() {
        String[] sampleString = {"This", "is", "a", "sample", "string"};
        System.out.print("That's the array: ");
        for (int i = 0; i < sampleString.length; i++) {
            if (i == 0) {
                System.out.print("\"" + sampleString[i]);
            } else if (i == sampleString.length - 1) {
                    System.out.print(" " + sampleString[i] + "\"");
            } else {
                System.out.print(" " + sampleString[i]);
            }
        }
        System.out.println("\nThis is the longest string in this string array: \"" + getTheLongestString(sampleString) + "\"");
    }



    // Method 2:
    // This method checks whether the string is a palindrome
    public static boolean checkIfPalindrome(String checkMe) {

        boolean palindrome = false;

        // Convert the original string into an array of characters and remove any spaces as well
        char[] originalArray = checkMe.toLowerCase().replace(" ", "").toCharArray();
        // Instantiate and initialize a new character array to store the reversed string in
        char[] reversedArray = new char[originalArray.length];
        // Populate the reversed array
        for (int i = 0; i < originalArray.length ; i++) {
            reversedArray[i] = originalArray[originalArray.length - i - 1];
        }

        // Needed to check that all characters are indeed the same
        int counter = 0;

        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] == reversedArray[i]) {
                counter++;
            }
        }
        if (counter == originalArray.length) {
            palindrome = true;
            return palindrome;
        }
        return palindrome;
    }

    // This method is a more elegant way of checking whether a string is a palindrome
    // Not to mention it only loops once
    public static boolean checkIfPalindromeSimpler(String checkMe) {
        // Trim any spaces and convert the string to lowercase
        String trimmed = checkMe.replace(" ", "").toLowerCase();
        int counter = 0;

        // Check that the string isn't empty
        if (trimmed.length() > 2) {
            // Only loop through half the string
            for (int i = 0; i < trimmed.length() / 2; i++) {
                // Check whether the currently checked character equals its counterpart
                if (trimmed.charAt(i) == trimmed.charAt(trimmed.length() - i - 1)) counter++;
            }
            // Check that the counter variable is equal to half the length of the given string
            if (counter == trimmed.length() / 2) return true;
        }
        // Not a palindrome
        return false;
    }

    // This method tests 'checkIfPalindrome'
    public static void testCheckIfPalindrome() {
        String sampleString = new String("UFO tofu");
        System.out.println("That's the original string: " + sampleString);
        System.out.println("\nIs this string a palindrome? " + checkIfPalindromeSimpler(sampleString));
    }



    // Method 3:
    // A method that changes a certain substring in a string to something else passed as a parameter
    public static String changeSubstring(String original, String changeMe, String addMe) {
        String copiedString = new String(original);
        String modifiedString = new String();
        if (copiedString.contains(changeMe)) {
            modifiedString = copiedString.replace(changeMe, addMe);
            return modifiedString;
        }
        return "No matches";
    }

    public static void testChangeSubstring() {
        String sampleString = "silvia goes where silvia goes...";
        System.out.println("Original string: \"" + sampleString + "\"");
        String modifiedString = changeSubstring(sampleString, "sil", "oli");
        System.out.println("That's a modified string: \"" + modifiedString + "\"");
    }



    // Method 4:
    // A method that checks the number of times a certain substring occurs in a string
    public static int getNumberOfOccurrences(String original, String findMe) {
        int counter = 0;
        int length = findMe.length();
        StringBuilder temporary;

        if (original.contains(findMe)) {
            temporary = new StringBuilder(original);
            int index = temporary.indexOf(findMe);

            while (index != -1) { // Index variable signifies that there's at least one occurrence
                // Keep deleting until there aren't any more occurrences
                temporary.delete(index, index + length);

                index = temporary.indexOf(findMe); // Update the index value
                counter += 1;
            }
            return counter;
        }
        return -1;
    }

    public static void testGetNumberOfOccurrences() {
        String sampleString = "Silvia goes where Silvia goes";
        String toFind = "Silvia";
        System.out.println("That's the string to ponder: \"" + sampleString + "\"");
        System.out.println("That's the number of times \"" + toFind + "\" occurs: " + getNumberOfOccurrences(sampleString, toFind));

    }


    // Method 5:
    // A method that inverts separate words in a given string
    public static String invertSubstrings(String original) {
        // Store individual words in a separate array
        String[] temporaryStringArray = original.split(" ");
        // StringBuilder to be used to reverse separate words
        StringBuilder builder;
        // Another builder to store the result of inversion
        StringBuilder result = new StringBuilder();

        // Iterate over the array, each time constructing a new builder to reverse the value
        for (int i = 0; i < temporaryStringArray.length; i++) {
            builder = new StringBuilder(temporaryStringArray[i]);
            builder.reverse();
            temporaryStringArray[i] = builder.toString();

            // Append every reversed value to a separate StringBuilder object
            if (i == temporaryStringArray.length - 1) {
                result.append(temporaryStringArray[i]);
            } else
            result.append(temporaryStringArray[i] + " ");
        }

        return result.toString();
    }

    public static void testInvertSubstrings() {
        String sampleString = "Silvia goes where Silvia goes";
        System.out.println("Original string: \"" + sampleString + "\"");
        System.out.println("Modified string: \"" + invertSubstrings(sampleString) + "\"");
    }

}
