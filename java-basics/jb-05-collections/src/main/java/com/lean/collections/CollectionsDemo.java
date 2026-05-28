package com.lean.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 集合框架演示：List 有序可重复，Set 不重复。
 * <p>对应文档：docs/java-basics/05-集合框架.md</p>
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("spring");
        list.add("java"); // List 允许重复
        System.out.println("List: " + list);

        Set<String> set = new HashSet<>(list);
        System.out.println("Set（去重）: " + set);

        List<String> words = List.of("java", "lean", "java", "lean", "java");
        System.out.println("词频: " + WordCounter.count(words));
    }
}
