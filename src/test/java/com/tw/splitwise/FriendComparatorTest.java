package com.tw.splitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FriendComparatorTest {
    @Test
    @DisplayName("Should compare two friends")
    void expectsToCompareFriends() {
        FriendComparator friendComparator = new FriendComparator();
        Friend friend1 = new Friend("Pulkit", 100.0, 0.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 0.0);
        int expectedDifference = -400;

        Assertions.assertEquals(expectedDifference, friendComparator.compare(friend1, friend2));
    }
}
