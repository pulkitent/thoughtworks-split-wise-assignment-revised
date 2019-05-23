package com.tw.splitwise;

import java.util.List;

public class PremiumGroupCharges implements Charges {
    static final double defaultAmountToPay = 0.0;

    @Override
    public void calculate(List<Friend> friends, List<Bill> bills) {
        Double totalAmount = Bill.findTotalAmount(bills);
        Integer noOfFriends = friends.size();
        Double charge = (0.02 * totalAmount) / noOfFriends;

        SettlementAmount settlementAmount = null;
        Friend splitwiseAdmin = new Friend("Splitwise", 0.0, defaultAmountToPay);
        for (Friend friend : friends) {
            settlementAmount = new SettlementAmount(charge, splitwiseAdmin);
            friend.addSettlementAmount(settlementAmount);
        }
    }
}