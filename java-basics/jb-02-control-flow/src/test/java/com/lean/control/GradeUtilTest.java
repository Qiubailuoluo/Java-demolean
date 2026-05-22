package com.lean.control;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * GradeUtil 边界测试（可选，用于 mvn test）。
 */
class GradeUtilTest {

    @Test
    void gradeAAt90() {
        assertEquals("A", GradeUtil.toGrade(90));
        assertEquals("A", GradeUtil.toGrade(100));
    }

    @Test
    void gradeBAt80() {
        assertEquals("B", GradeUtil.toGrade(80));
        assertEquals("B", GradeUtil.toGrade(89));
    }

    @Test
    void gradeCBelow80() {
        assertEquals("C", GradeUtil.toGrade(79));
        assertEquals("C", GradeUtil.toGrade(0));
    }

    @Test
    void invalidScoreThrows() {
        assertThrows(IllegalArgumentException.class, () -> GradeUtil.toGrade(-1));
        assertThrows(IllegalArgumentException.class, () -> GradeUtil.toGrade(101));
    }
}
