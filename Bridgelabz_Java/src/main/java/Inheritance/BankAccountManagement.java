
package Inheritance;

// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
    }

    void displayAccountType() {
        System.out.println("Account Type: General Bank Account");
    }
}

// Subclass 1
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance,
                   double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance,
                    double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        super.displayDetails();
        System.out.println("Withdrawal Limit: Rs. " + withdrawalLimit);
    }
}

// Subclass 3
class FixedDepositAccount extends BankAccount {
    int depositPeriod;
    double interestRate;

    FixedDepositAccount(String accountNumber, double balance,
                        int depositPeriod, double interestRate) {
        super(accountNumber, balance);
        this.depositPeriod = depositPeriod;
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        super.displayDetails();
        System.out.println("Deposit Period: " + depositPeriod + " years");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class
public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount[] accounts = {
                new SavingsAccount("SA101", 25000, 4.5),
                new CheckingAccount("CA102", 40000, 10000),
                new FixedDepositAccount("FD103", 100000, 3, 7.0)
        };

        for (BankAccount account : accounts) {
            System.out.println("\n------------------------");
            account.displayAccountType();
        }
    }
}
