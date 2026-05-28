package com.lean.oop;

/**
 * 圆：使用 {@code record} 不可变地保存半径，并实现 {@link Shape}。
 * <p>record 自动生成构造器、getter、equals、hashCode、toString。</p>
 */
public record Circle(double radius) implements Shape {

    public Circle {
        if (radius <= 0) {
            throw new IllegalArgumentException("半径必须为正: " + radius);
        }
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
