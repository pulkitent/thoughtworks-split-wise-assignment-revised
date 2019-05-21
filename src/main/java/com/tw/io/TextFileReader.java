package com.tw.io;

import com.tw.splitwise.Bill;
import com.tw.splitwise.BillType;
import com.tw.splitwise.Friend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TextFileReader implements Reader {
    private static final int one = 1;
    private static final int two = 2;
    private static final int three = 3;
    private static final double defaultAmountToPay = 0.0;
    private static final String comma = ",";
    private static final String alphabetRegex = "[\\D]";
    private static final String emptyString = "";

    @Override
    public List<Bill> read(List<Friend> friends) throws IOException {
        String line = "";

        String friendDetailsFilePath = "/Users/pulkit.gupta/Desktop/splitwise/src/main/resources/FriendDetails.csv";
        BufferedReader friendFileReader = new BufferedReader(new FileReader(friendDetailsFilePath));

        String billDetailsFilePath = "/Users/pulkit.gupta/Desktop/splitwise/src/main/resources/BillDetails.csv";
        BufferedReader billFileReader = new BufferedReader(new FileReader(billDetailsFilePath));

        List<Bill> bills = new LinkedList<>();

        while ((line = friendFileReader.readLine()) != null) {
            friends.add(createFriend(line));
        }

        while ((line = billFileReader.readLine()) != null) {
            bills.add(createBill(line, friends));
        }
        return bills;
    }

    private Friend createFriend(String line) {
        String[] friendRecord = line.split(comma);

        if (friendRecord.length != three)
            throw new RuntimeException("Record must be of size 3");

        String name = friendRecord[one];
        Double amount = Double.parseDouble(friendRecord[two]);

        Friend friend = new Friend(name, amount, defaultAmountToPay);
        return friend;
    }

    private Bill createBill(String line, List<Friend> friends) {
        String[] billRecord = line.split(comma);

        Double billAmount = Double.parseDouble(billRecord[one]);
        BillType type = BillType.valueOf(billRecord[two].toUpperCase());

        List<Friend> billWasPaidFor = new LinkedList<>();

        for (int recordIndex = three; recordIndex < billRecord.length; recordIndex++) {
            String stringId = billRecord[recordIndex].replaceAll(alphabetRegex, emptyString);
            int friendId = Integer.parseInt(stringId) - one;
            billWasPaidFor.add(friends.get(friendId));
        }

        Bill bill = new Bill(billAmount, type, billWasPaidFor, null);
        return bill;
    }
}