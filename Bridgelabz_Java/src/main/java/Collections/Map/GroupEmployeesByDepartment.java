package Collections.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem: Group Objects by Property
 * Group Employee objects by department in a
 * Map<String, List<Employee>>.
 */
public class GroupEmployeesByDepartment {
    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String toString() { return name; }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee employee : employees) {
            grouped.computeIfAbsent(employee.department, key -> new ArrayList<>())
                   .add(employee);
        }

        System.out.println(grouped);
    }
}
