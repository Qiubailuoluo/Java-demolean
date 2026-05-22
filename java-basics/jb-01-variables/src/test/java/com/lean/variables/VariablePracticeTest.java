package com.lean.variables;

import com.lean.variables.practice.LeapYearUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 【动手练习】jb-01 习题：请实现 {@link com.lean.variables.practice.LeapYearUtil} 等逻辑，
 * 完成后去掉对应测试上的 {@link Disabled}，再执行 {@code mvn test}。
 */
class VariablePracticeTest {

    /**
     * 习题 1：实现 {@link LeapYearUtil#isLeapYear(int)}。
     * <p>提示：2000 闰年，1900 平年，2024 闰年，2023 平年。</p>
     */
    @Test
    @Disabled("完成 LeapYearUtil.isLeapYear 后删除本 @Disabled")
    void exercise01_leapYear() {
        assertTrue(LeapYearUtil.isLeapYear(2000));
        assertTrue(LeapYearUtil.isLeapYear(2024));
        assertFalse(LeapYearUtil.isLeapYear(1900));
        assertFalse(LeapYearUtil.isLeapYear(2023));
    }

    /**
     * 习题 2：在本测试方法内用两行代码演示 valueOf(127) 的 {@code ==} 与 valueOf(128) 的差异，
     * 并用 assert 断言（不要改 {@link VariableDemo} 演示类）。
     */
    @Test
    @Disabled("在本方法内写完断言后删除 @Disabled")
    void exercise02_integerCacheInTest() {
        // TODO: Integer a = Integer.valueOf(127); ...
        // TODO: assertTrue(...); assertFalse(...);
    }

    /**
     * 习题 3：声明两个内容均为 "JavaLean" 的 String，一个用字面量、一个用 new；
     * 断言 {@code ==} 为 false、{@code equals} 为 true。
     */
    @Test
    @Disabled("写完断言后删除 @Disabled")
    void exercise03_stringCompare() {
        // TODO: 请你补充
    }
}
