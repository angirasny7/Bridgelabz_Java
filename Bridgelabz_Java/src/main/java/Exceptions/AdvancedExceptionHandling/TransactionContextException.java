package Exceptions.AdvancedExceptionHandling;
class TransactionProcessingException extends Exception {
    public TransactionProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
class TransactionService {
    public void processTransaction(String id, double amount)
            throws TransactionProcessingException {
        try {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            if (amount > 100000) throw new IllegalStateException("Transaction limit exceeded");
            System.out.println("Transaction " + id + " processed successfully.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new TransactionProcessingException(
                    "Transaction " + id + " failed for amount " + amount + ": " + e.getMessage(), e);
        }
    }
}
public class TransactionContextException {
    /*
     * Problem: Rethrow transaction failures as a custom exception.
     * Include transaction ID and amount to provide additional context.
     */
    public static void main(String[] args) {
        try {
            new TransactionService().processTransaction("TXN1024", 150000);
        } catch (TransactionProcessingException e) {
            System.out.println(e.getMessage());
        }
    }
}
