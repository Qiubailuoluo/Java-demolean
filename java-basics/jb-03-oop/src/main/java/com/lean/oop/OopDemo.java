package com.lean.oop;

import java.util.List;

/**
 * 面向对象演示：封装、多态（父类型引用指向子类对象）。
 * <p>对应文档：docs/java-basics/03-面向对象.md</p>
 */
public class OopDemo {

    public static void main(String[] args) {
        // 多态：List 元素类型是 Shape，实际对象是 Circle / Rectangle
        List<Shape> shapes = List.of(
                new Circle(2.0),
                new Rectangle(3.0, 4.0)
        );

        System.out.println("=== 各图形面积（多态调用 area） ===");
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " -> " + shape.area());
        }

        System.out.println("\n=== 总面积 ===");
        System.out.println(totalArea(shapes));
    }

    /** 多态求和：只依赖 Shape 接口，不关心具体类型 */
    static double totalArea(List<Shape> shapes) {
        double sum = 0;
        for (Shape s : shapes) {
            sum += s.area();
        }
        return sum;
    }
}
