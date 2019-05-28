package com.tw.splitwise;

import java.util.HashMap;
import java.util.Map;

import static com.tw.splitwise.CurrencyType.*;

public class CurrencyConverter {
    private final CurrencyType sourceCurrencyType;
    private final CurrencyType destinationCurrencyType;
    private static final Map<CurrencyType, Double> exchangeRate;

    static {
        exchangeRate = new HashMap<>();
        exchangeRate.put(INR, 1.0);
        exchangeRate.put(USD, 69.66);
        exchangeRate.put(JPY, 0.64);
        exchangeRate.put(EUR, 77.93);
    }

    public CurrencyConverter(CurrencyType sourceCurrencyType, CurrencyType destinationCurrencyType) {
        this.sourceCurrencyType = sourceCurrencyType;
        this.destinationCurrencyType = destinationCurrencyType;
    }

    public CurrencyType getDestinationCurrencyType() {
        return destinationCurrencyType;
    }

    Double convert(Double value) {
        Double baseCurrencyValue = convertToBaseCurrency(value, sourceCurrencyType);
        return convertFromBaseCurrency(baseCurrencyValue, destinationCurrencyType);
    }

    private Double convertToBaseCurrency(Double value, CurrencyType sourceCurrencyType) {
        Double rate = exchangeRate.get(sourceCurrencyType);
        return (rate * value);
    }

    private Double convertFromBaseCurrency(Double value, CurrencyType destinationCurrencyType) {
        Double rate = exchangeRate.get(destinationCurrencyType);
        return (value / rate);
    }
}