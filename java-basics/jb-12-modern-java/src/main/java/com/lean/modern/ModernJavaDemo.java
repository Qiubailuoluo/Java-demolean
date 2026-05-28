package com.lean.modern;

/**
 * Java 8～17 语法速览：文本块、switch 表达式、sealed、var。
 * <p>对应文档：docs/java-basics/12-Java8-17新特性速览.md</p>
 */
public class ModernJavaDemo {

    public static void main(String[] args) {
        // 文本块（Java 15+）：多行字符串，保留换行
        String json = """
                {
                  "course": "JavaLean",
                  "level": 17
                }
                """;
        System.out.println("=== 文本块 ===\n" + json);

        // var：局部变量类型推断（仍是静态类型）
        var card = new CardPayment("1234");
        var cash = new CashPayment(100.0);
        printPayment(card);
        printPayment(cash);

        // sealed + instanceof 模式匹配（Java 17）：穷尽已知子类型
        System.out.println("\n=== 支付类型分支 ===");
        Payment p = card;
        String channel;
        if (p instanceof CardPayment c) {
            channel = "银行卡(" + c.last4() + ")";
        } else if (p instanceof CashPayment c) {
            channel = "现金(" + c.amount() + ")";
        } else {
            throw new IllegalStateException("未知支付: " + p);
        }
        System.out.println(channel);
    }

    static void printPayment(Payment payment) {
        System.out.println(payment.getClass().getSimpleName() + ": " + payment.description());
    }
}
