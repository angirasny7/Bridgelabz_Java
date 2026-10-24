
/*
 * Problem 2: Bank and Account Holders (Association)
 * Define Bank and Customer classes.
 * A customer can have multiple bank accounts, and each account
 * is linked to a bank.
 * Implement openAccount() in Bank and viewBalance() in Customer
 * to demonstrate communication between associated objects.
 */

package ObjectModeling;

import java.util.ArrayList;

// Class to represent a Bank Account
class BankAccount {

    // Attributes to store account details
    String accountNumber;
    double balance;
    Bank bank;

    // Constructor to initialize account details
    BankAccount(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }
}

// Class to represent a Customer
class Customer {

    // Attributes to store customer details
    String name;
    ArrayList<BankAccount> accounts;

    // Constructor to initialize customer details
    Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    // Method to add an account to the customer
    void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to view balances of all customer accounts
    void viewBalance() {
        System.out.println("\nAccount details for " + name + ":");

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts) {
            System.out.println("Bank: " + account.bank.bankName);
            System.out.println("Account Number: " + account.accountNumber);
            System.out.printf("Balance: %.2f%n", account.balance);
            System.out.println();
        }
    }
}

// Class to represent a Bank
class Bank {

    // Attributes to store bank details
    String bankName;
    ArrayList<BankAccount> accounts;
    int nextAccountNumber = 1001;

    // Constructor to initialize bank details
    Bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    // Method to open an account for a customer
    void openAccount(Customer customer, double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative.");
            return;
        }

        // Generate an account number
        String accountNumber = String.valueOf(nextAccountNumber++);

        // Create an account linked to this bank
        BankAccount account =
                new BankAccount(accountNumber, initialBalance, this);

        // Associate the account with the bank and customer
        accounts.add(account);
        customer.addAccount(account);

        System.out.println("Account opened successfully for " + customer.name);
        System.out.println("Bank: " + bankName);
        System.out.println("Account Number: " + accountNumber);
    }
}

// Main class
public class BankAssociation {

    public static void main(String[] args) {

        // Create Bank objects
        Bank bank = new Bank("State Bank of India");

        // Create Customer objects
        Customer customer1 = new Customer("Rahul Sharma");
        Customer customer2 = new Customer("Priya Singh");

        // Open multiple accounts for customers
        bank.openAccount(customer1, 5000.0);
        System.out.println();

        bank.openAccount(customer1, 10000.0);
        System.out.println();

        bank.openAccount(customer2, 7500.0);

        // Customers view their account balances
        customer1.viewBalance();
        customer2.viewBalance();
    }
}
