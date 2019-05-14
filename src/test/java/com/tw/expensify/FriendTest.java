package com.tw.expensify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FriendTest {
    @Test
    @DisplayName("Should settle amount for a single friend")
    void expectsAmountToBeSettled() {
        Friend friend = new Friend("Pulkit", 100, 0);
        Friend settledFriend = new Friend("Pulkit", 100, 100);

        friend.settleAmount(100);

        Assertions.assertEquals(settledFriend, friend);
    }

    @Test
    @DisplayName("Should settle amount for a single friend with negative amount to pay")
    void expectsAmountToBeSettledForNegativeAmount() {
        Friend friend = new Friend("Pulkit", 100, 0);
        Friend settledFriend = new Friend("Pulkit", 100, -100);

        friend.settleAmount(-100);

        Assertions.assertEquals(settledFriend, friend);
    }

    @Test
    @DisplayName("Should stringify friend properly")
    void expectsToStringToStringify() {
        Friend friend = new Friend("Pulkit", 100, 0);
        String expectedStringifyFriend = "Pulkit";

        Assertions.assertEquals(expectedStringifyFriend, friend.toString());
    }

    @Test
    @DisplayName("Should compare two friends")
    void expectsEqualsToCompareTwoFriends() {
        Friend friend = new Friend("Pulkit", 100, 0);
        Friend anotherFriend = new Friend("Pulkit", 100, 0);

        Assertions.assertEquals(friend, anotherFriend);
    }

    @Test
    @DisplayName("Should compare two friend")
    void expectsToCompareTwoFriends() {
        Friend friend = new Friend("Rahul", 300, 100);
        Friend anotherFriend = new Friend("Pulkit", 200, 200);

        Assertions.assertEquals(200, friend.compare(friend, anotherFriend));
    }
}