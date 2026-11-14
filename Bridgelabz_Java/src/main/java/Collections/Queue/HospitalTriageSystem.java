package Collections.Queue;

import java.util.PriorityQueue;

/*
 * Problem: Hospital Triage System
 * Treat patients with higher severity first. A PriorityQueue orders
 * patients by descending severity; equal severities are ordered by name.
 */
public class HospitalTriageSystem {
    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return name + " (severity " + severity + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> triage = new PriorityQueue<>(
            (a, b) -> {
                int bySeverity = Integer.compare(b.severity, a.severity);
                return bySeverity != 0 ? bySeverity : a.name.compareTo(b.name);
            });

        triage.add(new Patient("John", 3));
        triage.add(new Patient("Alice", 5));
        triage.add(new Patient("Bob", 2));

        while (!triage.isEmpty()) {
            System.out.println("Treating: " + triage.remove());
        }
    }
}
