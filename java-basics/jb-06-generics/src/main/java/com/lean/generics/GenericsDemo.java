package com.lean.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型演示。
 * <p>对应文档：docs/java-basics/06-泛型.md</p>
 */
public class GenericsDemo {

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("age", 25);
        System.out.println(pair.left() + " = " + pair.right());

        List<String> names = new ArrayList<>(List.of("b", "a", "c"));
        ListUtils.swap(names, 0, 2);
        System.out.println("swap 后: " + names);

        List<Integer> src = List.of(1, 2, 3);
        List<Number> dest = new ArrayList<>();
        ListUtils.copy(src, dest);
        System.out.println("copy 到 Number 列表: " + dest);
    }
}
