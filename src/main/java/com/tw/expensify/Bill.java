package com.tw.expensify;

import java.util.List;

class Bill {
    private final Integer amount;
    private final BillType type;
    private final Friend paidBy;
    private final List<Friend> paidFor;

    Bill(Integer amount, BillType type, Friend paidBy, List<Friend> paidFor) {
        this.amount = amount;
        this.type = type;
        this.paidBy = paidBy;
        this.paidFor = paidFor;
    }

    void settleIndividualExpense(List<Friend> friends) {
        int friendsCount = paidFor.size();
        int perHeadAmount = amount / friendsCount;

        for (Friend friend : paidFor) {
            friend.settleAmount(perHeadAmount);
        }
    }
}