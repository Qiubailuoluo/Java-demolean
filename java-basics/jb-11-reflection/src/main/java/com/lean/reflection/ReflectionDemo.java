package com.lean.reflection;

/**
 * 反射与注解演示。
 * <p>对应文档：docs/java-basics/11-反射与注解.md</p>
 */
public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloService();
        AnnotationRunner.runMarkedMethods(service);
        System.out.println("调用次数: " + service.getInvokeCount());
    }
}
