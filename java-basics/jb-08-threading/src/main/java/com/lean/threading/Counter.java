package com.lean.threading;

/**
 * 线程安全计数器：{@code synchronized} 保证 {@code increment} 原子性。
 * <p>注意：{@code volatile} 只保证可见性，不保证 i++ 复合操作原子性。</p>
 */
public class Counter {

    private int value;

    public synchronized void increment() {
        value++;
    }

    public synchronized int get() {
        return value;
    }
}
