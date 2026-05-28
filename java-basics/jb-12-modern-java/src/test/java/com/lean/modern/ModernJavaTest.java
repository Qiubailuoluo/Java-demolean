package com.lean.modern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ModernJavaTest {

    @Test
    void sealedPaymentDescriptions() {
        Payment card = new CardPayment("9999");
        assertTrue(card.description().contains("9999"));
        Payment cash = new CashPayment(50);
        assertTrue(cash.description().contains("50"));
    }
}
