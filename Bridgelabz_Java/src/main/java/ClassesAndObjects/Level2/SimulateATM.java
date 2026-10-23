package ClassesAndObjects.Level2;
import java.util.Scanner;
/*
 * Question: Simulate an ATM
 * Create a BankAccount class with attributes accountHolder,
 * accountNumber, and balance.
 * Add methods to deposit money, withdraw money only if sufficient
 * balance exists, and display the current balance.
 */

class BankAccount{
    String accountHolder;
    long accountNumber;
    double balance;

    //Method to deposit money
    void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Amount deposited successfully.");
        }
        else{
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money if sufficient balance exists
    void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Invalid withdrawal amount.");
        }
        else if(amount <= balance){
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
        else{
            System.out.println("Insufficient balance.");
        }
    }

    // Method to display the current balance
    void displayBalance() {
        System.out.printf("Current Balance: %.2f%n", balance);
    }


}
public class SimulateATM {
    public static void main(String[] args) {

        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Create an object of the BankAccount class
        BankAccount account = new BankAccount();

        // Input account details
        System.out.print("Enter account holder name: ");
        account.accountHolder = input.nextLine();

        System.out.print("Enter account number: ");
        account.accountNumber = input.nextLong();

        System.out.print("Enter initial balance: ");
        account.balance = input.nextDouble();

        // Display account details
        System.out.println("\n----- ATM Menu -----");
        System.out.println("Account Holder: " + account.accountHolder);
        System.out.println("Account Number: " + account.accountNumber);

        // Perform deposit operation
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = input.nextDouble();
        account.deposit(depositAmount);

        // Perform withdrawal operation
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = input.nextDouble();
        account.withdraw(withdrawAmount);

        // Display the updated balance
        account.displayBalance();

        // Close the Scanner
        input.close();
    }
}
