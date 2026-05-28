package com.lean.oop;

import java.util.Objects;

/**
 * 矩形：普通类封装宽高，手动实现 {@link #equals(Object)} / {@link #hashCode()}。
 * <p>规则：重写 equals 必须同时重写 hashCode，否则在 HashMap/HashSet 中行为异常。</p>
 */
public class Rectangle implements Shape {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("宽高必须为正");
        }
        this.width = width;
        this.height = height;
    }

    public double width() {
        return width;
    }

    public double height() {
        return height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle other)) {
            return false;
        }
        return Double.compare(width, other.width) == 0
                && Double.compare(height, other.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + "}";
    }
}
