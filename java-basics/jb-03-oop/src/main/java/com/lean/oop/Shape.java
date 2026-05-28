package com.lean.oop;

/**
 * 图形契约：计算面积。接口定义「能做什么」，不关心具体形状如何存储数据。
 */
public interface Shape {

    /** @return 面积 */
    double area();
}
