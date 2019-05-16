package com.tw.splitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class ExpenseTest {
    @Test
    @DisplayName("Should settle expense between four friends having three bills")
    void expectsExpensesToBeSettledForFourFriends() {
        List<Friend> friends = new LinkedList<>();
        Bills bills = new Bills(createThreeTestBills(friends));
        List<Friend> settledFriends = getFourExpectedSettledFriends();

        bills.settle(friends);

        Assertions.assertEquals(settledFriends, friends);
    }

    @Test
    @DisplayName("Should settle expense between two friends having two bills")
    void expectsExpensesToBeSettled() {
        List<Friend> friends = new LinkedList<>();
        List<Bill> bills = createTwoTestBills(friends);
        Bills expense = new Bills(bills);
        List<Friend> settledFriends = getTwoExpectedSettledFriends();

        expense.settle(friends);

        Assertions.assertEquals(settledFriends, friends);
    }

    private List<Friend> getTwoExpectedSettledFriends() {
        List<Friend> friends = new LinkedList<>();
        Friend friend1 = new Friend("Pulkit", 100.0, 300.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 300.0);

        friends.add(friend1);
        friends.add(friend2);

        return friends;
    }

    private List<Bill> createTwoTestBills(List<Friend> friends) {
        Friend friend1 = new Friend("Pulkit", 100.0, 0.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 0.0);

        friends.add(friend1);
        friends.add(friend2);

        List<Friend> firstBillPaidFor = new LinkedList<>();
        firstBillPaidFor.add(friend1);
        firstBillPaidFor.add(friend2);

        List<Friend> secondBillPaidFor = new LinkedList<>();
        secondBillPaidFor.add(friend1);
        secondBillPaidFor.add(friend2);

        Bill bill1 = new Bill(100.0, BillType.FOOD, friend1, firstBillPaidFor, null);
        Bill bill2 = new Bill(500.0, BillType.CAB, friend2, secondBillPaidFor, null);

        List<Bill> bills = new LinkedList<>();
        bills.add(bill1);
        bills.add(bill2);

        return bills;
    }

    private List<Friend> getFourExpectedSettledFriends() {
        List<Friend> friends = new LinkedList<>();
        Friend friend1 = new Friend("Pulkit", 100.0, 150.0);
        Friend friend2 = new Friend("Abhishek", 450.0, 175.0);
        Friend friend3 = new Friend("Ravinder", 0.0, 275.0);
        Friend friend4 = new Friend("Charan", 300.0, 275.0);

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);

        return friends;
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

        Bill bill1 = new Bill(100.0, BillType.FOOD, friend1, firstBillPaidFor, null);
        Bill bill2 = new Bill(500.0, BillType.CAB, friend2, secondBillPaidFor, null);
        Bill bill3 = new Bill(300.0, BillType.MOVIE, friend4, thirdBillPaidFor, null);

        List<Bill> bills = new LinkedList<>();
        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);

        return bills;
    }
}