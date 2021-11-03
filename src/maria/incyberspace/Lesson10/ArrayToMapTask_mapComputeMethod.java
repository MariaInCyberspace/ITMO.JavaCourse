package maria.incyberspace.Lesson10;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ArrayToMapTask_mapComputeMethod {
    public static void main(String[] args) {
        Integer[] sampleArray = getRandomArrayOfIntegers(1000000);
        Map<Integer, Integer> map = arrayToMap(sampleArray);
        System.out.println(map);

        // Check that it works with a much smaller-sized array
        Integer[] arr = new Integer[] { 2, 2, 4, 5, 5 };
        Map<Integer, Integer> map1 = arrayToMap(arr);
        System.out.println(map1);
    }

    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        // To measure the time elapsed
        Instant start = Instant.now(Clock.tickMillis(ZoneId.systemDefault()));

        // Instantiate a new HashMap object to be filled with values in the for-loop below
        Map<K, Integer> map = new HashMap<>();
        // Iterate over the array that was passed as this method's parameter
        for (K k : ks) {
            // Call 'compute' method pertinent to Maps that takes two arguments: key and a remapping function
            // It would try to compute a mapping for the specified key and its current value
            // In this case the current value would be the number of times this specified key occurs in the array calculated by a BiFunction
            // Since the map isn't filled with <K, V> pairs upon first iteration, first 'V' returned by the remapping function would be 1
            // If the specified key occurs again, then it's a duplicate, and the remapping function will replace the value of this key, incrementing it by 1
            map.compute(k, (oldKey, newValue) -> newValue == null ? 1 : newValue + 1);
        }
        // Calculate time elapsed and log the result to the console
        Instant finish = Instant.now(Clock.tickMillis(ZoneId.systemDefault()));
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Map.compute: " + timeElapsed);
        return map;
    }

    public static Integer[] getRandomArrayOfIntegers(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5000);
        }
        return array;
    }
}
