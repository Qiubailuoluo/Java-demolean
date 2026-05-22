package com.lean.variables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * jb-01 可选验收测试：验证字符串与装箱的核心行为。
 * <p>测试非刚需，用于 {@code mvn test} 快速回归；学习以 {@link VariableDemo#main} 为主。</p>
 */
class VariableDemoTest {

    @Test
    void stringEqualsComparesContent() {
        assertTrue(new String("hi").equals(new String("hi")));
        assertFalse(new String("hi") == new String("hi"));
    }

    @Test
    void integerValueOf128UsuallyNotSameReference() {
        assertEquals(Integer.valueOf(128), Integer.valueOf(128));
        // 超出默认缓存 -128～127 时，== 通常为 false
        assertFalse(Integer.valueOf(128) == Integer.valueOf(128));
    }
}
