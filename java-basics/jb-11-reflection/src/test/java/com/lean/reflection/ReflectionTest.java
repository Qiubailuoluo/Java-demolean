package com.lean.reflection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReflectionTest {

    @Test
    void runMarkedMethod() throws Exception {
        HelloService service = new HelloService();
        AnnotationRunner.runMarkedMethods(service);
        assertEquals(1, service.getInvokeCount());
    }
}
