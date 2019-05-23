package com.tw.io;

import com.tw.splitwise.Bill;
import com.tw.splitwise.BillType;
import com.tw.splitwise.Friend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static com.tw.io.Constant.*;

public class TextFileReader implements Reader {

    @Override
    public List<Bill> read(List<Friend> friends) throws IOException {
        String workingDirectory = System.getProperty("user.dir");

        readFriendDetails(friends, workingDirectory);

        List<Bill> bills = readBillDetails(friends, workingDirectory);

        return bills;
    }

    private List<Bill> readBillDetails(List<Friend> friends, String workingDirectory) throws IOException {
        String line;
        List<Bill> bills = new LinkedList<>();

        String billDetailsFilePath = workingDirectory + "/src/main/resources/BillDetails.csv";
        BufferedReader billFileReader = new BufferedReader(new FileReader(billDetailsFilePath));

        while ((line = billFileReader.readLine()) != null) {
            bills.add(createBill(line, friends));
        }
        return bills;
    }

    private void readFriendDetails(List<Friend> friends, String workingDirectory) throws IOException {
        String line;
        String friendDetailsFilePath = workingDirectory + "/src/main/resources/FriendDetails.csv";
        BufferedReader friendFileReader = new BufferedReader(new FileReader(friendDetailsFilePath));

        while ((line = friendFileReader.readLine()) != null) {
            friends.add(createFriend(line));
        }
    }

    private Friend createFriend(String line) {
        String[] friendRecord = line.split(comma);

        if (friendRecord.length != three) {

            throw new RuntimeException(sizeMustBeThreeErrorMessage);
        }

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