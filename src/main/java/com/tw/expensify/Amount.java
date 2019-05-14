package com.tw.expensify;

class Amount {
    private final Integer value;
    private final Friend toBePaidTo;

    Amount(Integer value, Friend toBePaidTo) {
        this.value = value;
        this.toBePaidTo = toBePaidTo;
    }

    @Override
    public String toString() {
        return value + " " + toBePaidTo;
    }
}