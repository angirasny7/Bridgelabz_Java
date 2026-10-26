package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 4: Banking System
 *
 * Description:
 * Create a banking system with an abstract BankAccount class,
 * SavingsAccount and CurrentAccount subclasses, and a Loanable
 * interface.
 *
 * Implement encapsulation using private fields and validation.
 * Use abstraction for interest calculation, inheritance for account
 * types, and polymorphism to process different accounts.
 */

// Interface defining loan-related operations
interface Loanable {

    // Check whether the requested loan can be approved
    boolean applyForLoan(double amount);

    // Calculate the maximum eligible loan amount
    double calculateLoanEligibility();
}

// Abstract parent class for bank accounts
abstract class BankAccount {

    private final String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName,
                       double balance) {
        if (accountNumber == null ||
                accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Account number cannot be empty."
            );
        }

        this.accountNumber = accountNumber;
        setHolderName(holderName);
        setBalance(balance);
    }

    // Account number is immutable after construction
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Account holder name cannot be empty."
            );
        }
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Protected setter prevents direct external balance modification
    protected void setBalance(double balance) {
        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException(
                    "Balance must be non-negative and finite."
            );
        }
        this.balance = balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be positive and finite."
            );
        }

        if (!Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException(
                    "Balance would exceed the supported limit."
            );
        }

        balance += amount;
        System.out.printf("Deposited: Rs. %.2f%n", amount);
    }

    // Withdraw money only when sufficient balance is available
    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be positive and finite."
            );
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.printf("Withdrawn: Rs. %.2f%n", amount);
    }

    // Subclasses define their own interest calculations
    public abstract double calculateInterest();

    // Display common account information
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.printf("Balance: Rs. %.2f%n", balance);
        System.out.printf("Interest: Rs. %.2f%n",
                calculateInterest());
    }
}

// Savings account implementation
class SavingsAccount extends BankAccount implements Loanable {

    private static final double INTEREST_RATE = 0.04;
    private static final double LOAN_MULTIPLIER = 2.0;

    public SavingsAccount(String accountNumber, String holderName,
                          double balance) {
        super(accountNumber, holderName, balance);
    }

    // Savings account earns illustrative annual interest of 4%
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_MULTIPLIER;
    }

    @Override
    public boolean applyForLoan(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        return amount <= calculateLoanEligibility();
    }
}

// Current account implementation
class CurrentAccount extends BankAccount implements Loanable {

    private static final double INTEREST_RATE = 0.01;
    private static final double LOAN_MULTIPLIER = 1.0;

    public CurrentAccount(String accountNumber, String holderName,
                          double balance) {
        super(accountNumber, holderName, balance);
    }

    // Current account earns illustrative annual interest of 1%
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_MULTIPLIER;
    }

    @Override
    public boolean applyForLoan(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        return amount <= calculateLoanEligibility();
    }
}

// Main class
public class BankingSystem {

    public static void main(String[] args) {

        // Create different bank account objects
        SavingsAccount savings = new SavingsAccount(
                "SAV1001", "Rahul", 50000
        );

        CurrentAccount current = new CurrentAccount(
                "CUR2001", "Priya", 100000
        );

        // Demonstrate deposit and withdrawal
        savings.deposit(5000);
        savings.withdraw(2000);

        current.deposit(10000);
        current.withdraw(5000);

        // Polymorphism: store both account types in one list
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(savings);
        accounts.add(current);

        // Each account calculates interest using its own method
        for (BankAccount account : accounts) {
            System.out.println("\n----------------------");
            account.displayDetails();

            // Both account types also implement Loanable
            Loanable loanAccount = (Loanable) account;

            double eligibleAmount =
                    loanAccount.calculateLoanEligibility();

            System.out.printf("Loan Eligibility: Rs. %.2f%n",
                    eligibleAmount);

            double requestedLoan = 40000;

            if (loanAccount.applyForLoan(requestedLoan)) {
                System.out.printf(
                        "Loan of Rs. %.2f is eligible.%n",
                        requestedLoan
                );
            } else {
                System.out.printf(
                        "Loan of Rs. %.2f is not eligible.%n",
                        requestedLoan
                );
            }
        }
    }
}
