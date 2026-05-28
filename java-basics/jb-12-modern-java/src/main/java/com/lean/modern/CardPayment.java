package com.lean.modern;

/** 银行卡支付 */
public record CardPayment(String last4) implements Payment {

    @Override
    public String description() {
        return "卡尾号 " + last4;
    }
}
