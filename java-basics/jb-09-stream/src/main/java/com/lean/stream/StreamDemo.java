package com.lean.stream;

import java.util.List;

/**
 * Lambda 与 Stream 演示。
 * <p>对应文档：docs/java-basics/09-Lambda与Stream.md</p>
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "Dev", 12000),
                new Employee(2, "Bob", "Dev", 15000),
                new Employee(3, "Carol", "HR", 9000)
        );

        System.out.println("平均薪资: " + EmployeeStats.averageSalary(employees));
        EmployeeStats.highestPaid(employees)
                .ifPresent(e -> System.out.println("最高薪资: " + e.name() + " " + e.salary()));
        System.out.println("按部门: " + EmployeeStats.namesByDepartment(employees));

        long devCount = employees.stream()
                .filter(e -> e.department().equals("Dev"))
                .count();
        System.out.println("Dev 人数: " + devCount);
    }
}
