package Collections.Set;

import java.time.LocalDate;
import java.util.*;

/*
 * Problem: Insurance Policy Management Using Sets
 * Store unique policies using HashSet, LinkedHashSet and TreeSet.
 * Retrieve policies expiring within 30 days, filter by coverage,
 * and identify duplicate policy numbers from an input collection.
 */
public class InsurancePolicySetManagement {
    static class Policy {
        private final String number;
        private final String holder;
        private final LocalDate expiryDate;
        private final String coverage;
        private final double premium;

        Policy(String number, String holder, LocalDate expiryDate, String coverage, double premium) {
            this.number = number;
            this.holder = holder;
            this.expiryDate = expiryDate;
            this.coverage = coverage;
            this.premium = premium;
        }

        String getNumber() { return number; }
        LocalDate getExpiryDate() { return expiryDate; }
        String getCoverage() { return coverage; }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Policy)) return false;
            return number.equals(((Policy) obj).number);
        }

        @Override
        public int hashCode() { return Objects.hash(number); }

        @Override
        public String toString() {
            return number + " | " + holder + " | " + expiryDate + " | " + coverage + " | " + premium;
        }
    }

    public static void main(String[] args) {
        List<Policy> input = List.of(
            new Policy("P101", "Asha", LocalDate.now().plusDays(10), "Health", 12000),
            new Policy("P102", "Ravi", LocalDate.now().plusDays(45), "Auto", 8000),
            new Policy("P103", "Meera", LocalDate.now().plusDays(20), "Home", 15000),
            new Policy("P101", "Asha", LocalDate.now().plusDays(10), "Health", 12000)
        );

        Set<Policy> hashSet = new HashSet<>(input);
        Set<Policy> linkedSet = new LinkedHashSet<>(input);

        // TreeSet orders policies by expiry date, then by policy number.
        Set<Policy> treeSet = new TreeSet<>(
            Comparator.comparing(Policy::getExpiryDate).thenComparing(Policy::getNumber));
        treeSet.addAll(input);

        System.out.println("Unique policies (HashSet): " + hashSet);
        System.out.println("Insertion order (LinkedHashSet): " + linkedSet);
        System.out.println("Expiry order (TreeSet): " + treeSet);

        System.out.println("Expiring within 30 days:");
        hashSet.stream()
            .filter(p -> !p.getExpiryDate().isBefore(LocalDate.now())
                      && !p.getExpiryDate().isAfter(LocalDate.now().plusDays(30)))
            .forEach(System.out::println);

        System.out.println("Health policies:");
        hashSet.stream().filter(p -> p.getCoverage().equalsIgnoreCase("Health"))
            .forEach(System.out::println);

        // Detect duplicate policy numbers in the original input.
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (Policy policy : input) {
            if (!seen.add(policy.getNumber())) duplicates.add(policy.getNumber());
        }
        System.out.println("Duplicate policy numbers: " + duplicates);

        // Basic performance experiment: timings depend on machine and data size.
        benchmark("HashSet", new HashSet<>(), input);
        benchmark("LinkedHashSet", new LinkedHashSet<>(), input);
        benchmark("TreeSet", new TreeSet<>(
            Comparator.comparing(Policy::getExpiryDate).thenComparing(Policy::getNumber)), input);
    }

    private static void benchmark(String name, Set<Policy> set, List<Policy> data) {
        long start = System.nanoTime();
        set.addAll(data);
        long addTime = System.nanoTime() - start;

        Policy sample = data.get(0);
        start = System.nanoTime();
        set.contains(sample);
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        set.remove(sample);
        long removeTime = System.nanoTime() - start;

        System.out.printf("%s - add: %d ns, search: %d ns, remove: %d ns%n",
                name, addTime, searchTime, removeTime);
    }
}
