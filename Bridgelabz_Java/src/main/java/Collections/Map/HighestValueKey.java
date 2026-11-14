package Collections.Map;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Find the Key with the Highest Value
 * Find and return the key associated with the maximum integer value.
 * If the map is empty, return null.
 */
public class HighestValueKey {
    public static String findHighestKey(Map<String, Integer> map) {
        String highestKey = null;
        int highestValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestValue) {
                highestValue = entry.getValue();
                highestKey = entry.getKey();
            }
        }
        return highestKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> values = new HashMap<>();
        values.put("A", 10);
        values.put("B", 20);
        values.put("C", 15);
        System.out.println("Highest key: " + findHighestKey(values));
    }
}
