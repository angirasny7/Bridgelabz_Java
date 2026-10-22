package Strings.Level1;

public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;

        System.out.println(text.length());
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled!");
            System.out.println("Error: Cannot call a String method on a null reference.");
        }
    }

    public static void main(String[] args) {

        System.out.println("Calling method to generate exception:");

        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println();

        System.out.println("Calling method to handle exception:");

        handleException();

        System.out.println("Program continues normally.");
    }
}
