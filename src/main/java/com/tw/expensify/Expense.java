package com.tw.expensify;

import java.util.List;

class Expense {
    private final List<Bill> bills;

    Expense(List<Bill> bills) {
        this.bills = bills;
    }

    void settle() {
        for (Bill bill : bills) {
            bill.settleIndividualExpense();
        }
    }
}