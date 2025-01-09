package com.edstem.ecld.assesment;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private final String name;
    private final String department;
    private final double salary;
    private final List<String> skills;

    // Constructor
    public Employee(String name, String department, double salary, List<String> skills) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }
    // Appropriate Getters for Class Employee
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }
}

class DepartmentStats {
    private final double averageSalary;
    private final long employeeCount;
    private final Set<String> uniqueSkills;

    public DepartmentStats(double averageSalary, long employeeCount, Set<String> uniqueSkills) {
        this.averageSalary = averageSalary;
        this.employeeCount = employeeCount;
        this.uniqueSkills = uniqueSkills;
    }

    public String getAverageSalary() {
        return String.format("%.2f",averageSalary);
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public Set<String> getUniqueSkills() {
        return uniqueSkills;
    }
}

public class EmployeeStatistics {
    public static Map<String, DepartmentStats> analyzeDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.filtering(e -> e.getDepartment() != null,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        deptEmployees -> {
                                            double avgSalary = deptEmployees.stream()
                                                    .mapToDouble(Employee::getSalary)
                                                    .average()
                                                    .orElse(0.0);

                                            Set<String> uniqueSkills = deptEmployees.stream()
                                                    .flatMap(e -> e.getSkills().stream())
                                                    .collect(Collectors.toSet());

                                            return new DepartmentStats(avgSalary, deptEmployees.size(), uniqueSkills);
                                        }
                                )
                        )
                ))
                .entrySet().stream()
                .filter(e -> e.getValue().getEmployeeCount() > 2)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    public static void main(String[] args) {

        // Hardcoded entries
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 75000, Arrays.asList("Java", "SQL")),
                new Employee("Alice", "IT", 82000, Arrays.asList("Python", "Java")),
                new Employee("Bob", "HR", 65000, Arrays.asList("Communication", "Speaking Skills")),
                new Employee("Charlie", "IT", 78000, Arrays.asList("Java", "AWS"))
        );

        Map<String, DepartmentStats> departmentStats = analyzeDepartments(employees);

        departmentStats.forEach((department, stats) -> {
            System.out.println("Department: " + department);
            System.out.println("Average Salary: " + stats.getAverageSalary());
            System.out.println("Employee Count: " + stats.getEmployeeCount());
            System.out.println("Unique Skills: " + stats.getUniqueSkills());
        });
    }
}
