package com.tw.io;

import com.tw.splitwise.Bill;
import com.tw.splitwise.Friend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TextFileReader implements Reader {

    @Override
    public List<Bill> read(List<Friend> friends) throws IOException {
        String line = "";
        String filePath = "";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<Bill> bills = new LinkedList<>();

        while ((line = reader.readLine()) != null) {
            bills.add(createBill(line));
        }
        return bills;
    }

    private Bill createBill(String line) {
        String[] bill = line.split(",");
        if (bill.length != 7)
            throw new RuntimeException("Record must be of size 7");
        return null;
    }
}