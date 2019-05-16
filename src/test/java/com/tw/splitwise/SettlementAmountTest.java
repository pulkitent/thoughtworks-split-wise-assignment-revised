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

    @Test
    @DisplayName("Should find whether two settlement amounts are equal or not")
    void expectsToCheckEquality() {
        SettlementAmount settlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));
        SettlementAmount anotherSettlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));

        Assertions.assertTrue(settlementAmount.equals(anotherSettlementAmount));
    }

    @Test
    @DisplayName("Should compute hash of settlement amount properly")
    void expectedHashToBeComputed() {
        SettlementAmount settlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));
        int expectedHash = -814204880;

        Assertions.assertEquals(expectedHash, settlementAmount.hashCode());
    }
}