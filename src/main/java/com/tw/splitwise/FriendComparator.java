package com.tw.splitwise;

import java.util.Comparator;

//This class represents a comparator to compare two friends
class FriendComparator implements Comparator<Friend> {
    @Override
    public int compare(Friend friend, Friend anotherFriend) {
        return friend.compare(anotherFriend);
    }
}