package com.tw.expensify;

import java.util.Objects;

class Friend {
    private final String Name;
    private Integer amountToPay;
    private final Integer amountPaid;

    Friend(String name, Integer amountPaid, Integer amountToPay) {
        this.Name = name;
        this.amountPaid = amountPaid;
        this.amountToPay = amountToPay;
    }

    void settleAmount(int amount) {
        amountToPay += amount;
    }

    @Override
    public String toString() {
        int finalAmount = amountPaid - amountToPay;
        String action = finalAmount >= 0 ? "gets" : "gives";
        return Name + " " + action + " " + Math.abs(finalAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(Name, friend.Name) &&
                Objects.equals(amountToPay, friend.amountToPay) &&
                Objects.equals(amountPaid, friend.amountPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, amountToPay, amountPaid);
    }
}