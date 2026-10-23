
/*
 * Problem 3: Bank Account Management
 * Create a BankAccount class with public accountNumber,
 * protected accountHolder, and private balance.
 * Write public methods to access and modify balance.
 * Create a SavingsAccount subclass to demonstrate access
 * to accountNumber and accountHolder.
 */

package Constructor.Level3;

// Parent class
class BankAccount {

    // Public member: accessible from anywhere
    public long accountNumber;

    // Protected member: accessible within the package and subclasses
    protected String accountHolder;

    // Private member: accessible only within the BankAccount class
    private double balance;

    // Constructor to initialize bank account details
    BankAccount(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;

        // Initialize balance only if it is non-negative
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Invalid initial balance. Set to zero.");
        }
    }

    // Public method to access the private balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Subclass extending BankAccount
class SavingsAccount extends BankAccount {

    // Additional attribute for a savings account
    double interestRate;

    // Constructor to initialize savings account details
    SavingsAccount(long accountNumber, String accountHolder,
                   double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to demonstrate access to inherited members
    void displayDetails() {

        // Public member accessed directly
        System.out.println("Account Number: " + accountNumber);

        // Protected member accessed directly in the subclass
        System.out.println("Account Holder: " + accountHolder);

        // Private balance accessed through the public getter
        System.out.printf("Balance: %.2f%n", getBalance());

        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class
public class BankAccountManagement {

    public static void main(String[] args) {

        // Create a SavingsAccount object
        SavingsAccount account = new SavingsAccount(
                123456789L, "Rahul Sharma", 10000.0, 4.5
        );

        // Display initial account details
        System.out.println("----- Account Details -----");
        account.displayDetails();

        // Deposit money
        System.out.println("\nDepositing 2000...");
        account.deposit(2000);

        // Withdraw money
        System.out.println("\nWithdrawing 1500...");
        account.withdraw(1500);

        // Display updated balance using the getter
        System.out.printf("%nUpdated Balance: %.2f%n",
                account.getBalance());
    }
}
