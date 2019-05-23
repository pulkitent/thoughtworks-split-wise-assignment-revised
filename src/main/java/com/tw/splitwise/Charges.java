package com.tw.splitwise;

import java.util.List;

//This interface represents the extra premium charges paid by user
public interface Charges {
    public void calculate(List<Friend> friends, List<Bill> bills);
}