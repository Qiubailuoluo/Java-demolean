package com.lean.exception;

import java.io.IOException;
import java.io.StringReader;

/**
 * 异常机制演示：try-with-resources、异常链。
 * <p>对应文档：docs/java-basics/04-异常机制.md</p>
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("=== 正常除法 ===");
        System.out.println("10 / 2 = " + DivideService.divide(10, 2));

        System.out.println("\n=== 除零（捕获 BusinessException） ===");
        try {
            DivideService.divide(10, 0);
        } catch (BusinessException e) {
            System.out.println("捕获: " + e.getMessage());
        }

        System.out.println("\n=== try-with-resources（自动关闭 StringReader） ===");
        try {
            readFirstChar("Hi");
            System.out.println("读取成功");
        } catch (IOException e) {
            // 包装为运行时异常并保留 cause，便于排查
            throw new IllegalStateException("读取失败", e);
        }
    }

    /** Checked 异常：调用方必须处理或再抛出 */
    static char readFirstChar(String text) throws IOException {
        try (StringReader reader = new StringReader(text)) {
            return (char) reader.read();
        }
    }
}
