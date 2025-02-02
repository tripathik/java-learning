package com.iintelliguru.stream.problems.strong;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployee {
    public static void main(String[] args) {
        /**
         * Given a list of employees,
         * group them by department and calculate the average salary for each department
         */

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 5000),
                new Employee("Bob", "IT", 6000),
                new Employee("Charlie", "IT", 7000),
                new Employee("Diana", "HR", 4500),
                new Employee("Eve", "Finance", 8000)
        );

        Map<String, Double> result =  employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(result);
    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Employee{
        private String name;
        private String department;
        private double salary;
    }
}
