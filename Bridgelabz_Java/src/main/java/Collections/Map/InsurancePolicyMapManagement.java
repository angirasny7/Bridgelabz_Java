package Collections.Map;

import java.time.LocalDate;
import java.util.*;

/*
 * Problem: Insurance Policy Management Using Maps
 * Store policies by policy number in HashMap and LinkedHashMap.
 * Maintain a TreeMap ordered by expiry date, retrieve by number,
 * find policies expiring within 30 days, filter by policyholder,
 * and remove expired policies.
 */
public class InsurancePolicyMapManagement {
    static class Policy {
        String number;
        String holder;
        LocalDate expiryDate;
        String coverage;
        double premium;

        Policy(String number, String holder, LocalDate expiryDate, String coverage, double premium) {
            this.number = number;
            this.holder = holder;
            this.expiryDate = expiryDate;
            this.coverage = coverage;
            this.premium = premium;
        }

        public String toString() {
            return number + " | " + holder + " | " + expiryDate + " | " + coverage + " | " + premium;
        }
    }

    public static void main(String[] args) {
        List<Policy> policies = List.of(
            new Policy("P101", "Asha", LocalDate.now().plusDays(10), "Health", 12000),
            new Policy("P102", "Ravi", LocalDate.now().plusDays(45), "Auto", 8000),
            new Policy("P103", "Asha", LocalDate.now().minusDays(2), "Home", 15000)
        );

        Map<String, Policy> hashMap = new HashMap<>();
        Map<String, Policy> linkedMap = new LinkedHashMap<>();
        Map<LocalDate, List<Policy>> expiryMap = new TreeMap<>();

        for (Policy policy : policies) {
            hashMap.put(policy.number, policy);
            linkedMap.put(policy.number, policy);
            expiryMap.computeIfAbsent(policy.expiryDate, key -> new ArrayList<>()).add(policy);
        }

        System.out.println("Retrieve P101: " + hashMap.get("P101"));
        System.out.println("Insertion order: " + linkedMap.values());
        System.out.println("Expiry-date order: " + expiryMap);

        System.out.println("Expiring within 30 days:");
        hashMap.values().stream()
            .filter(p -> !p.expiryDate.isBefore(LocalDate.now())
                      && !p.expiryDate.isAfter(LocalDate.now().plusDays(30)))
            .forEach(System.out::println);

        System.out.println("Policies for Asha:");
        hashMap.values().stream()
            .filter(p -> p.holder.equalsIgnoreCase("Asha"))
            .forEach(System.out::println);

        // Remove policies whose expiry date is before today.
        hashMap.values().removeIf(p -> p.expiryDate.isBefore(LocalDate.now()));
        System.out.println("After removing expired policies: " + hashMap.values());
    }
}
