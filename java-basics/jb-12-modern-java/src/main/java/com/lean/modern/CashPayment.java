package com.lean.modern;

/** 现金支付 */
public record CashPayment(double amount) implements Payment {

    @Override
    public String description() {
        return "现金 " + amount + " 元";
    }
}
