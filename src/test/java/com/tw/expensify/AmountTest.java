package com.tw.expensify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {
    @Test
    @DisplayName("Should stringify amount properly")
    void expectsToStringifyAmounnt() {
        Amount amount = new Amount(100, new Friend("Rahul", 100, 100));
        String expectedStringifiedAmount = "100 Rahul";

        Assertions.assertEquals(expectedStringifiedAmount, amount.toString());
    }
}
