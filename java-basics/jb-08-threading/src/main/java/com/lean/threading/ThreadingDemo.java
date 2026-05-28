package com.lean.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 多线程演示：线程池 + Future 求 1～100 的和。
 * <p>对应文档：docs/java-basics/08-多线程.md</p>
 */
public class ThreadingDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try {
            Future<Integer> future = pool.submit(() -> {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            });
            System.out.println("1～100 的和 = " + future.get());
        } finally {
            pool.shutdown();
            pool.awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
