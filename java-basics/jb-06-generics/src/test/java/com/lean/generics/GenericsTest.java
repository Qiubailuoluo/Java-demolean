package com.lean.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericsTest {

    @Test
    void copyWithWildcards() {
        List<Integer> src = List.of(10, 20);
        List<Number> dest = new ArrayList<>();
        ListUtils.copy(src, dest);
        assertEquals(List.of(10, 20), dest);
    }
}
