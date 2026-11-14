package Collections.List;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem: Find Frequency of Elements
 * Count how many times each string occurs in a list and store
 * each string with its count in a Map<String, Integer>.
 */
public class FindFrequency {
    public static Map<String, Integer> countFrequency(List<String> words) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            // Increase the existing count, or start at one.
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        return frequency;
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apple", "orange");
        System.out.println(countFrequency(words));
    }
}
