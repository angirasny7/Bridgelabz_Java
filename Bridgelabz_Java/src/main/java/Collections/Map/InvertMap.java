package Collections.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem: Invert a Map
 * Reverse the key-value relationship. If multiple original keys
 * share a value, collect those keys in a list under that value.
 */
public class InvertMap {
    public static <K, V> Map<V, List<K>> invert(Map<K, V> input) {
        Map<V, List<K>> result = new HashMap<>();

        for (Map.Entry<K, V> entry : input.entrySet()) {
            result.computeIfAbsent(entry.getValue(), key -> new ArrayList<>())
                  .add(entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = Map.of("A", 1, "B", 2, "C", 1);
        System.out.println(invert(input));
    }
}
