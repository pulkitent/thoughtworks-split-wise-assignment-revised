package com.tw.splitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SettlementAmountTest {
    @Test
    @DisplayName("Should stringify amount properly")
    void expectsToStringifyAmounnt() {
        SettlementAmount settlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));
        String expectedStringifiedAmount = "100.0 Rahul";

        Assertions.assertEquals(expectedStringifiedAmount, settlementAmount.toString());
    }
}