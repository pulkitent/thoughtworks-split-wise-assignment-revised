package com.tw.splitwise;

import java.util.List;

public interface Charges {
    public void calculate(List<Friend> friends, List<Bill> bills);
}