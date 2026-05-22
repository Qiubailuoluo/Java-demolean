package com.lean.control;

import com.lean.control.practice.LoopPracticeUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 【动手练习】jb-02 习题：实现 {@link com.lean.control.practice.LoopPracticeUtil} 后去掉 {@link Disabled}。
 */
class ControlFlowPracticeTest {

    @Test
    @Disabled("完成 LoopPracticeUtil.sum1ToN 后删除 @Disabled")
    void exercise01_sum1To100() {
        assertEquals(5050, LoopPracticeUtil.sum1ToN(100));
        assertEquals(1, LoopPracticeUtil.sum1ToN(1));
    }

    @Test
    @Disabled("完成 LoopPracticeUtil.fizzBuzzLabel 后删除 @Disabled")
    void exercise02_fizzBuzzLabel() {
        assertEquals("1", LoopPracticeUtil.fizzBuzzLabel(1));
        assertEquals("Fizz", LoopPracticeUtil.fizzBuzzLabel(3));
        assertEquals("Buzz", LoopPracticeUtil.fizzBuzzLabel(5));
        assertEquals("FizzBuzz", LoopPracticeUtil.fizzBuzzLabel(15));
    }

    /**
     * 习题 3：在有序数组 {@code {2,5,8,12,20}} 中二分查找目标下标（找不到返回 -1）。
     * 可在本测试类内写私有静态方法 {@code binarySearch(int[], int)}，或新建 practice 类。
     */
    @Test
    @Disabled("实现二分查找后删除 @Disabled")
    void exercise03_binarySearch() {
        int[] arr = {2, 5, 8, 12, 20};
        // TODO: 调用你实现的 binarySearch
        // assertEquals(2, binarySearch(arr, 8));
        // assertEquals(-1, binarySearch(arr, 7));
    }
}
