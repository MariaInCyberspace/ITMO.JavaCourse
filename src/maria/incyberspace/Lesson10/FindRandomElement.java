package maria.incyberspace.Lesson10;

import java.time.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class FindRandomElement {
    public static void main(String[] args) {
        // Instantiate and initialize a new ArrayList
        ArrayList<Integer> arrList = new ArrayList<>();
        // Fill it with values
        ArrayList<Integer> arrayList = fillArrayList(arrList);
        // Instantiate and initialize a new LinkedList
        LinkedList<Integer> linkList = new LinkedList<>();
        // Fill it with values
        LinkedList<Integer> linkedList = fillLinkedList(linkList);
        
        // See the time elapsed to print out 100000 random elements
        long a = printRandomElementsOfArrayList(arrayList);
        long b = printRandomElementsOfLinkedList(linkedList);
        System.out.println(a);
        System.out.println(b);
    }
    
    // A method that populates an ArrayList
    public static ArrayList<Integer> fillArrayList(ArrayList<Integer> list) throws NullPointerException {
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        return list;
    }
    
    // A method that populates a LinkedList
    public static LinkedList<Integer> fillLinkedList(LinkedList<Integer> list) throws NullPointerException {
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        return list;
    }
    // Print 100000 random elements of an ArrayList and check out how much time it takes
    public static long printRandomElementsOfArrayList(ArrayList<Integer> list) throws NullPointerException {
        Random random = new Random();
        Instant start = Instant.now(Clock.tickMillis(ZoneId.systemDefault()));
        for (int i = 0; i < 100000; i++) {
            System.out.print(list.get(random.nextInt(100000)) + " ");
        }
        Instant finish = Instant.now(Clock.tickMillis(ZoneId.systemDefault()));
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("\nTime elapsed to view 100000 elements in an ArrayList: " + timeElapsed);
        return timeElapsed;
    }

    // Print 100000 random elements of a LinkedList and check out how much time it takes
    public static long printRandomElementsOfLinkedList(LinkedList<Integer> list) throws NullPointerException {
        Random random = new Random();
        Instant start = Instant.now(Clock.tickMillis(ZoneId.systemDefault()));
        for (int i = 0; i < 100000; i++) {
            System.out.print(list.get(random.nextInt(100000)) + " ");
        }
        Instant finish = Instant.now(Clock.tickMillis(ZoneId.systemDefault()));
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("\nTime elapsed to view 100000 elements in a LinkedList: " + timeElapsed);
        return timeElapsed;
    }


}
