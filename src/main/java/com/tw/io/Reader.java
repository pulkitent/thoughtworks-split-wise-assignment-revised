package com.tw.io;

import com.tw.splitwise.Bill;
import com.tw.splitwise.Friend;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Bill> read(List<Friend> friends) throws IOException;
}