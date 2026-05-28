package com.lean.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    @Test
    void totalAreaOfCircleAndRectangle() {
        List<Shape> shapes = List.of(new Circle(1.0), new Rectangle(2.0, 3.0));
        // π*1^2 + 6
        assertEquals(Math.PI + 6.0, OopDemo.totalArea(shapes), 1e-9);
    }
}
