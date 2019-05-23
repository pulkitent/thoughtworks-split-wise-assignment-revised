package com.tw.splitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static com.tw.splitwise.Constant.splitwiseRate;

class PremiumGroupChargesTest {
    @Test
    @DisplayName("Should calculate premium charges when number of friends are >= 5")
    void expectPremiumChargesToBeCalculated() {
        List<Friend> friends = new LinkedList<>();
        Charges charges = new PremiumGroupCharges(splitwiseRate);
        List<Bill> bills = createFourTestBills(friends);
        List<Friend> expectedSettledFriends = getFiveExpectedSettledFriends();

        charges.calculate(friends, bills);

        Assertions.assertEquals(expectedSettledFriends, friends);
    }

    private List<Friend> getFiveExpectedSettledFriends() {
        List<Friend> friends = new LinkedList<>();
        Friend friend1 = new Friend("Pulkit", 100.0, 0.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 0.0);
        Friend friend3 = new Friend("Ravinder", 0.0, 0.0);
        Friend friend4 = new Friend("Charan", 300.0, 0.0);
        Friend friend5 = new Friend("Pranav", 100.0, 0.0);
        Friend splitWiseAdmin = new Friend("Splitwise", 0.0, 0.0);

        SettlementAmount settlementAmount = new SettlementAmount(4.0, splitWiseAdmin);
        friend1.addSettlementAmount(settlementAmount);
        friend2.addSettlementAmount(settlementAmount);
        friend3.addSettlementAmount(settlementAmount);
        friend4.addSettlementAmount(settlementAmount);
        friend5.addSettlementAmount(settlementAmount);

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);
        friends.add(friend5);

        return friends;
    }

    private List<Bill> createFourTestBills(List<Friend> friends) {
        Friend friend1 = new Friend("Pulkit", 100.0, 0.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 0.0);
        Friend friend3 = new Friend("Ravinder", 0.0, 0.0);
        Friend friend4 = new Friend("Charan", 300.0, 0.0);
        Friend friend5 = new Friend("Pranav", 100.0, 0.0);

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);
        friends.add(friend5);

        List<Friend> firstBillPaidFor = new LinkedList<>();
        firstBillPaidFor.add(friend1);
        firstBillPaidFor.add(friend2);
        firstBillPaidFor.add(friend3);
        firstBillPaidFor.add(friend4);

        List<Friend> secondBillPaidFor = new LinkedList<>();
        secondBillPaidFor.add(friend3);
        secondBillPaidFor.add(friend4);

        List<Friend> thirdBillPaidFor = new LinkedList<>();
        thirdBillPaidFor.add(friend1);
        thirdBillPaidFor.add(friend2);

        List<Friend> fourthBillPaidFor = new LinkedList<>();
        fourthBillPaidFor.add(friend1);
        fourthBillPaidFor.add(friend2);

        Bill bill1 = new Bill(100.0, BillType.FOOD, firstBillPaidFor, null);
        Bill bill2 = new Bill(500.0, BillType.CAB, secondBillPaidFor, null);
        Bill bill3 = new Bill(300.0, BillType.MOVIE, thirdBillPaidFor, null);
        Bill bill4 = new Bill(100.0, BillType.MOVIE, thirdBillPaidFor, null);

        List<Bill> bills = new LinkedList<>();
        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);
        bills.add(bill4);

        return bills;
    }
}