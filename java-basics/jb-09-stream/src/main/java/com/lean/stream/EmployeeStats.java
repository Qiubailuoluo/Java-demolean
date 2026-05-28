package com.lean.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Stream API 聚合示例。
 */
public final class EmployeeStats {

    private EmployeeStats() {
    }

    /** 全体平均薪资 */
    public static double averageSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0.0);
    }

    /** 薪资最高的员工（Optional 避免 null） */
    public static Optional<Employee> highestPaid(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::salary));
    }

    /** 按部门分组姓名列表 */
    public static java.util.Map<String, List<String>> namesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));
    }
}
