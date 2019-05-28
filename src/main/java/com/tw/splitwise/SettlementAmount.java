package com.tw.splitwise;

import java.util.Objects;

//This class represents debt amount to be paid to whom
public class SettlementAmount {
    private final Double value;
    private final Friend toBePaidTo;

    SettlementAmount(Double value, Friend toBePaidTo) {
        this.value = value;
        this.toBePaidTo = toBePaidTo;
    }

    public String toString(CurrencyConverter converter) {
        Double convertedValue = converter == null ? value : converter.convert(value);
        String currencyType = converter.getDestinationCurrencyType().toString();
        return currencyType + " " + convertedValue + " " + toBePaidTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettlementAmount settlementAmount = (SettlementAmount) o;
        return Objects.equals(value, settlementAmount.value) &&
                Objects.equals(toBePaidTo, settlementAmount.toBePaidTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, toBePaidTo);
    }
}