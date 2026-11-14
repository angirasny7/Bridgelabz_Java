package Exceptions.AdvancedExceptionHandling;
class SampleConnection implements AutoCloseable {
    public void connect() { System.out.println("Connection established."); }
    public void execute() {
        System.out.println("Executing operation...");
        throw new RuntimeException("An error occurred during the operation.");
    }
    @Override
    public void close() {
        System.out.println("Connection closed. Resources cleaned up.");
    }
}
public class ResourceCleanupDemo {
    /*
     * Problem: Manage a connection that must be cleaned up after use.
     * Use try-with-resources so close() runs even when an exception occurs.
     */
    public static void main(String[] args) {
        try (SampleConnection connection = new SampleConnection()) {
            connection.connect();
            connection.execute();
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
