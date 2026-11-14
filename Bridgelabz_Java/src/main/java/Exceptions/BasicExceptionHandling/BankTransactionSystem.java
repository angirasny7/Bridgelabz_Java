package Exceptions.BasicExceptionHandling;
import java.util.Scanner;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) { super(message); }
}
class BankAccount {
    private double balance;
    public BankAccount(double balance) { this.balance = balance; }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) throw new IllegalArgumentException("Invalid amount!");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance!");
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}
public class BankTransactionSystem {
    /*
     * Problem: Validate bank withdrawal requests.
     * Handle negative amounts and withdrawals greater than the balance.
     */
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            try {
                account.withdraw(amount);
            } catch (InsufficientBalanceException | IllegalArgumentException e) {
                System.out.println(e instanceof InsufficientBalanceException
                        ? "Insufficient balance!" : "Invalid amount!");
            }
        }
    }
}
