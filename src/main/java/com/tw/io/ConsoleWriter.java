package com.tw.io;

import com.tw.splitwise.CurrencyConverter;
import com.tw.splitwise.Friend;
import com.tw.splitwise.SettlementAmount;

import java.util.List;

import static com.tw.io.Constant.hasToPay;

public class ConsoleWriter implements Writer {
    @Override
    public void write(List<Friend> friends, CurrencyConverter converter) {
        for (Friend friend : friends) {
            for (SettlementAmount settlementAmount : friend.getSettlementAmount()) {
                System.out.println(friend + hasToPay + settlementAmount.toString(converter));
            }
        }
    }
}