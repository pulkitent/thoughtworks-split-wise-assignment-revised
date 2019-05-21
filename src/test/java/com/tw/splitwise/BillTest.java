package com.tw.splitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class BillTest {
    @Test
    @DisplayName("Should settleBills single bill between two friends")
    void expectsToSettleIndividualExpenseForTwoFriends() {
        List<Friend> friends = new LinkedList<>();
        Bill bill = getBillForTwoFriends(friends);
        List<Friend> expectedSettledFriend = getExpectedSettledFriends();

        bill.settle();

        Assertions.assertEquals(friends, expectedSettledFriend);
    }

    @Test
    @DisplayName("Should settleBills single bill for a single person")
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
}