package Collections.Map;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Merge Two Maps
 * Combine two maps. When a key exists in both maps, add their
 * integer values; otherwise, keep the value from the map containing it.
 */
public class MergeMaps {
    public static Map<String, Integer> merge(
            Map<String, Integer> first, Map<String, Integer> second) {
        Map<String, Integer> result = new HashMap<>(first);

        for (Map.Entry<String, Integer> entry : second.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> first = Map.of("A", 1, "B", 2);
        Map<String, Integer> second = Map.of("B", 3, "C", 4);
        System.out.println(merge(first, second));
    }
}
