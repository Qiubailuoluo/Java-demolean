package com.lean.generics;

/**
 * 泛型类：左右两个类型参数可不同。
 *
 * @param <L> 左值类型
 * @param <R> 右值类型
 */
public record Pair<L, R>(L left, R right) {
}
