package com.tw.io;

import com.tw.splitwise.CurrencyConverter;
import com.tw.splitwise.Friend;

import java.util.List;

public interface Writer {
    void write(List<Friend> friends, CurrencyConverter converter);
}