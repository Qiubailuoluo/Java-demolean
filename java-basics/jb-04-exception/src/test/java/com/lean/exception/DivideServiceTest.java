package com.lean.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivideServiceTest {

    @Test
    void divideNormally() {
        assertEquals(5.0, DivideService.divide(10, 2));
    }

    @Test
    void divideByZeroThrowsBusinessException() {
        BusinessException ex = assertThrows(BusinessException.class, () -> DivideService.divide(1, 0));
        assertEquals("除数不能为 0", ex.getMessage());
    }
}
