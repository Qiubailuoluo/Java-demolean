package com.lean.variables;

/**
 * 变量与数据类型入门演示。
 * <p>对应文档：docs/java-basics/01-变量与数据类型.md</p>
 */
public class VariableDemo {

    public static void main(String[] args) {
        // ---------- 1. 八种基本类型（各举一例） ----------
        byte small = 127;
        short count = 1000;
        int age = 25;
        long population = 1_400_000_000L;
        float ratio = 0.5f;
        double price = 19.99;
        char gradeChar = 'A';
        boolean active = true;

        // ---------- 2. 引用类型：String（不可变） ----------
        String name = "JavaLean";

        // ---------- 3. 包装类与自动装箱 ----------
        // int 自动装箱为 Integer；显式创建可用 valueOf
        Integer boxedAge = Integer.valueOf(age);

        System.out.println("=== 基本类型与 String ===");
        System.out.println(name + " age=" + age + " price=" + price
                + " active=" + active + " grade=" + gradeChar);
        System.out.println("small=" + small + " count=" + count
                + " population=" + population + " ratio=" + ratio);
        System.out.println("装箱后 Integer: " + boxedAge);

        // ---------- 4. 字符串比较：equals 比较内容，== 比较引用 ----------
        demonstrateStringCompare();

        // ---------- 5. Integer 缓存池（-128～127） ----------
        demonstrateIntegerCache();
    }

    /**
     * 演示：比较字符串内容应使用 {@link String#equals(Object)}，不要用 {@code ==}。
     */
    static void demonstrateStringCompare() {
        String a = new String("JavaLean");
        String b = new String("JavaLean");
        String c = "JavaLean"; // 字符串常量池
        String d = "JavaLean";

        System.out.println("\n=== 字符串比较 ===");
        System.out.println("new String 两次 == : " + (a == b));           // false，不同对象
        System.out.println("new String equals   : " + a.equals(b));       // true，内容相同
        System.out.println("字面量两次 ==       : " + (c == d));           // true，同一常量池引用
    }

    /**
     * 演示：{@link Integer#valueOf(int)} 在 -128～127 内可能返回同一缓存实例。
     */
    static void demonstrateIntegerCache() {
        Integer x = Integer.valueOf(127);
        Integer y = Integer.valueOf(127);
        Integer m = Integer.valueOf(128);
        Integer n = Integer.valueOf(128);

        System.out.println("\n=== Integer 缓存池 ===");
        System.out.println("valueOf(127) == : " + (x == y));   // 常为 true（缓存范围内）
        System.out.println("valueOf(128) == : " + (m == n));   // 常为 false（超出默认缓存）
        System.out.println("valueOf(128) equals: " + m.equals(n)); // true，比较数值
    }
}
