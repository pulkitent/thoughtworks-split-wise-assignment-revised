package com.tw.splitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class BillTest {
    @Test
    @DisplayName("Should settle single bill between two friends")
    void expectsToSettleIndividualExpenseForTwoFriends() {
        List<Friend> friends = new LinkedList<>();
        Bill bill = getBillForTwoFriends(friends);
        List<Friend> expectedSettledFriend = getExpectedSettledFriends();

        bill.settle();

        Assertions.assertEquals(friends, expectedSettledFriend);
    }

    @Test
    @DisplayName("Should settle single bill for a single person")
    void expectsToSettleIndividualExpense() {
        List<Friend> friends = new LinkedList<>();
        List<Friend> firstBillPaidFor = new LinkedList<>();
        Friend friend = new Friend("Pulkit", 100.0, 0.0);
        Friend settledFriend = new Friend("Pulkit", 100.0, 100.0);
        friends.add(friend);
        firstBillPaidFor.add(friend);
        Bill bill = new Bill(100.0, BillType.FOOD, firstBillPaidFor, null);

        bill.settle();

        Assertions.assertEquals(friend, settledFriend);
    }

    @Test
    @DisplayName("Should calculate total amount of all bills")
    void expectsTotalBillAmountToBeFound() {
        List<Friend> friends = new LinkedList<>();
        List<Bill> testBills = createThreeTestBills(friends);

        Double totalAmount = Bill.findTotalAmount(testBills);

        Assertions.assertEquals(900, totalAmount);
    }

    private List<Friend> getExpectedSettledFriends() {
        Friend settledFriend = new Friend("Pulkit", 100.0, 50.0);
        Friend anotherSettledFriend = new Friend("Abhishek", 500.0, 50.0);

        List<Friend> friends = new LinkedList<>();
        friends.add(settledFriend);
        friends.add(anotherSettledFriend);

        return friends;
    }

    private Bill getBillForTwoFriends(List<Friend> friends) {
        Friend friend1 = new Friend("Pulkit", 100.0, 0.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 0.0);

        friends.add(friend1);
        friends.add(friend2);

        Bill bill = new Bill(100.0, BillType.FOOD, friends, null);
        return bill;
    }

    private List<Bill> createThreeTestBills(List<Friend> friends) {
        Friend friend1 = new Friend("Pulkit", 100.0, 0.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 0.0);
        Friend friend3 = new Friend("Ravinder", 0.0, 0.0);
        Friend friend4 = new Friend("Charan", 300.0, 0.0);

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);

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

        Bill bill1 = new Bill(100.0, BillType.FOOD, firstBillPaidFor, null);
        Bill bill2 = new Bill(500.0, BillType.CAB, secondBillPaidFor, null);
        Bill bill3 = new Bill(300.0, BillType.MOVIE, thirdBillPaidFor, null);

        List<Bill> bills = new LinkedList<>();
        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);

        return bills;
    }
}