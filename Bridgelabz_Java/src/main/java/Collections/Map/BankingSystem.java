package Collections.Map;

import java.util.*;

/*
 * Problem: Implement a Banking System
 * Store account balances in a HashMap, display accounts ordered
 * by balance using a TreeMap, and process withdrawal requests
 * in first-in-first-out order using a Queue.
 */
public class BankingSystem {
    static class Withdrawal {
        String accountNumber;
        double amount;

        Withdrawal(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Map<String, Double> accounts = new HashMap<>();
        accounts.put("A100", 5000.0);
        accounts.put("A200", 2500.0);
        accounts.put("A300", 9000.0);

        // TreeMap uses balance as key; account number is stored as value.
        // For real systems, use a comparator or list to handle equal balances.
        Map<Double, List<String>> accountsByBalance = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            accountsByBalance.computeIfAbsent(entry.getValue(), key -> new ArrayList<>())
                             .add(entry.getKey());
        }
        System.out.println("Accounts sorted by balance: " + accountsByBalance);

        Queue<Withdrawal> requests = new LinkedList<>();
        requests.add(new Withdrawal("A100", 1000));
        requests.add(new Withdrawal("A200", 3000));
        requests.add(new Withdrawal("A300", 2000));

        while (!requests.isEmpty()) {
            Withdrawal request = requests.remove();
            Double balance = accounts.get(request.accountNumber);

            if (balance == null) {
                System.out.println("Unknown account: " + request.accountNumber);
            } else if (balance >= request.amount) {
                accounts.put(request.accountNumber, balance - request.amount);
                System.out.println("Withdrawal approved: " + request.accountNumber
                        + ", remaining balance: " + accounts.get(request.accountNumber));
            } else {
                System.out.println("Insufficient balance: " + request.accountNumber);
            }
        }
    }
}
