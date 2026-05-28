package com.lean.reflection;

import java.lang.reflect.Method;

/**
 * 扫描对象上带 {@link Mark} 的方法并调用（极简版「框架」行为）。
 */
public final class AnnotationRunner {

    private AnnotationRunner() {
    }

    public static void runMarkedMethods(Object target) throws ReflectiveOperationException {
        Class<?> clazz = target.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Mark.class)) {
                method.setAccessible(true);
                Object result = method.invoke(target);
                System.out.println("调用 " + method.getName() + " -> " + result);
            }
        }
    }
}
