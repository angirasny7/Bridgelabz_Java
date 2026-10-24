
/*
 * Sample Program 1: Bank Account System
 * 1. Use a static variable bankName shared by all accounts.
 * 2. Use a static method getTotalAccounts() to display account count.
 * 3. Use this to initialize accountHolderName and accountNumber.
 * 4. Use a final accountNumber that cannot be changed after initialization.
 * 5. Use instanceof to check the object type before displaying details.
 */

package ThisStaticFinal;

// Class to represent a Bank Account
class BankAccount {

    // Static variable shared by all bank accounts
    static String bankName = "State Bank of India";

    // Static variable to count the total accounts created
    static int totalAccounts = 0;

    // Instance variables
    String accountHolderName;

    // Final variable: must be initialized once and cannot be reassigned
    final long accountNumber;

    // Constructor to initialize account details
    BankAccount(String accountHolderName, long accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;

        // Increment the total account count
        totalAccounts++;
    }

    // Static method to display the total number of accounts
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    // Instance method to display account details
    void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }
}

// Main class
public class BankAccountSystem {

    public static void main(String[] args) {

        // Create BankAccount objects
        BankAccount account1 =
                new BankAccount("Rahul Sharma", 10001L);

        BankAccount account2 =
                new BankAccount("Priya Singh", 10002L);

        // Store an account object in an Object reference
        Object obj = account1;

        // Check the object's type using instanceof
        if (obj instanceof BankAccount) {
            System.out.println("Object is a BankAccount.");
            System.out.println("\n----- Account Details -----");

            // Type cast the Object reference to BankAccount
            BankAccount account = (BankAccount) obj;
            account.displayDetails();
        } else {
            System.out.println("Object is not a BankAccount.");
        }

        // Display details of the second account
        System.out.println("\n----- Second Account -----");
        account2.displayDetails();

        // Call the static method using the class name
        System.out.println();
        BankAccount.getTotalAccounts();
    }
}
