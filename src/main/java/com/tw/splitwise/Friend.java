package com.tw.splitwise;

import java.util.*;

//This class represents a person who was involved in the trip
class Friend {
    private final String name;
    private Double amountToPay;
    private Double amountPaid;
    private final List<SettlementAmount> settlementAmounts;

    Friend(String name, Double amountPaid, Double amountToPay) {
        this.name = name;
        this.amountPaid = amountPaid;
        this.amountToPay = amountToPay;
        this.settlementAmounts = new LinkedList<>();
    }

    List<SettlementAmount> printSettlementAmount() {
        return settlementAmounts;
    }

    void updateAmountToPay(Double amount) {
        this.amountToPay += amount;
    }

    void settlementAmountWith(Friend friend, Double amount) {
        this.amountToPay = this.amountToPay - amount;
        this.addSettlementAmount(new SettlementAmount(amount, friend));
    }

    void receiveAmountFrom(Friend friend, Double amount) {
        this.amountPaid = this.amountPaid - amount;
        friend.addSettlementAmount(new SettlementAmount(amount, this));
    }

    Double calculatePaidAndToPayDifference() {
        return this.amountPaid - this.amountToPay;
    }

    void addSettlementAmount(SettlementAmount settlementAmount) {
        this.settlementAmounts.add(settlementAmount);
    }

    int compare(Friend friend) {
        Integer finalAmount = (int) Math.abs(friend.amountPaid - friend.amountToPay);
        Integer anotherFinalAmount = (int) Math.abs(this.amountPaid - this.amountToPay);

        return anotherFinalAmount - finalAmount;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(name, friend.name) &&
                Objects.equals(amountToPay, friend.amountToPay) &&
                Objects.equals(amountPaid, friend.amountPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}