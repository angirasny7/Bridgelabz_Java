package Collections.Map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Word Frequency Counter
 * Read text from a file, ignore case and punctuation, and count
 * each word using a HashMap.
 *
 * Run with a text-file path as the first command-line argument.
 */
public class WordFrequencyCounter {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> frequency = new HashMap<>();

        // Replace punctuation with spaces, then split on whitespace.
        String cleaned = text.toLowerCase().replaceAll("[^a-z0-9\\\\s]", " ");
        for (String word : cleaned.trim().split("\\\\s+")) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        return frequency;
    }

    public static void main(String[] args) throws IOException {
        String text;
        if (args.length > 0) {
            text = Files.readString(Path.of(args[0]));
        } else {
            text = "Hello world, hello Java!";
            System.out.println("No file supplied; using sample text.");
        }
        System.out.println(countWords(text));
    }
}
