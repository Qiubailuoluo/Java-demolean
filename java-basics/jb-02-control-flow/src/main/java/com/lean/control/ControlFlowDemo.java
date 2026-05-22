package com.lean.control;

/**
 * 流程控制演示：FizzBuzz（for + if-else）、等级示例（switch）。
 * <p>对应文档：docs/java-basics/02-流程控制.md</p>
 */
public class ControlFlowDemo {

    public static void main(String[] args) {
        System.out.println("=== switch 表达式：分数转等级 ===");
        int[] samples = {95, 85, 72, 60};
        for (int score : samples) {
            System.out.println("score=" + score + " -> grade=" + GradeUtil.toGrade(score));
        }

        System.out.println("\n=== FizzBuzz 1～30（for + continue 思维） ===");
        printFizzBuzz(30);
    }

    /**
     * 经典 FizzBuzz：3 的倍数输出 Fizz，5 的倍数 Buzz，公倍数 FizzBuzz。
     *
     * @param max 上限（含）
     */
    static void printFizzBuzz(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
