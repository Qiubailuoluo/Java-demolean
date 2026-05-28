package com.lean.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法与 PECS 示例。
 */
public final class ListUtils {

    private ListUtils() {
    }

    /** 交换列表中两个下标的元素（泛型方法，&lt;T&gt; 写在返回值前） */
    public static <T> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    /**
     * 从源列表复制到目标列表。
     * <p>PECS：源是生产者用 {@code ? extends T}（只读），目标是消费者用 {@code ? super T}（只写）。</p>
     */
    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        dest.clear();
        dest.addAll(src);
    }

    public static <T> List<T> of(T... items) {
        return new ArrayList<>(List.of(items));
    }
}
