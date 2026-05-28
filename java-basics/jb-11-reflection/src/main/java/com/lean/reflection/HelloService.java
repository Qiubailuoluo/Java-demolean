package com.lean.reflection;

/**
 * 被反射调用的目标类。
 */
public class HelloService {

    private int invokeCount;

    @Mark
    public String hello() {
        invokeCount++;
        return "Hello, reflection!";
    }

    public int getInvokeCount() {
        return invokeCount;
    }
}
