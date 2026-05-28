package com.lean.collections;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void countWords() {
        Map<String, Integer> freq = WordCounter.count(List.of("a", "b", "a"));
        assertEquals(2, freq.get("a"));
        assertEquals(1, freq.get("b"));
    }
}
