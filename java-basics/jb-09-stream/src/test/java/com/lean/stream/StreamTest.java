package com.lean.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamTest {

    @Test
    void averageSalary() {
        List<Employee> list = List.of(
                new Employee(1, "a", "D", 10000),
                new Employee(2, "b", "D", 20000)
        );
        assertEquals(15000.0, EmployeeStats.averageSalary(list));
    }
}
