package com.lean.control;

/**
 * 根据分数返回等级（switch 表达式，Java 14+）。
 * <p>对应文档：docs/java-basics/02-流程控制.md</p>
 */
public final class GradeUtil {

    private GradeUtil() {
    }

    /**
     * 将 0～100 的分数转为等级。
     *
     * @param score 分数，闭区间 [0, 100]
     * @return {@code A}（90+）、{@code B}（80～89）、{@code C}（其余及格分）
     * @throws IllegalArgumentException 分数越界
     */
    public static String toGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("分数须在 0～100 之间，当前: " + score);
        }
        // switch 表达式：case 合并、箭头语法，无需 break
        return switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            default -> "C";
        };
    }
}
