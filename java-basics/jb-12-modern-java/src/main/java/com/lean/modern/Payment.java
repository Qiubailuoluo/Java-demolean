package com.lean.modern;

/**
 * {@code sealed} 接口：仅允许列出的实现类继承/实现，编译期封闭类型层次。
 */
public sealed interface Payment permits CardPayment, CashPayment {

    String description();
}
