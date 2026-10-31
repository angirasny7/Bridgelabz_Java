package LinearBinaryStringConcepts.StringConcepts;

public class ConcatenateStringsUsingStringBuffer {

    public static void main(String[] args) {

        // Initialize an array of strings
        String[] words = {"Hello", " ", "World", "!"};

        // Create a StringBuffer object
        StringBuffer result = new StringBuffer();

        // Traverse the array and append each string
        for (int i = 0; i < words.length; i++) {

            // Append the current string to StringBuffer
            result.append(words[i]);
        }

        // Display the concatenated string
        System.out.println("Concatenated String: " + result);

    }
}
