package com.tw.io;

import com.tw.splitwise.Bill;
import com.tw.splitwise.BillType;
import com.tw.splitwise.Friend;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.tw.io.Constant.*;

public class ConsoleReader implements Reader {

    @Override
    public List<Bill> read(List<Friend> friends) {
        Scanner scanner = new Scanner(System.in);
        readFriendDetails(friends, scanner);

        List<Bill> bills = readBillDetails(friends, scanner);
        return bills;
    }

    private List<Bill> readBillDetails(List<Friend> friends, Scanner scanner) {
        List<Bill> bills = new LinkedList<>();

        System.out.println(enterNumberOfBills);
        int noOfBills = scanner.nextInt();

        if (noOfBills == zero) {
            System.out.println(invalidInputZeroBillsErrorMessage);
            throw new RuntimeException(zeroBillsErrorMessage);
        }

        for (int billIndex = zero; billIndex < noOfBills; billIndex++) {
            System.out.println(EnterAmountOfBill + (billIndex + one));
            Double amount = scanner.nextDouble();
            System.out.println(enterTheTypeOfBill);
            String type = scanner.next();

            BillType billType = BillType.valueOf(type.toUpperCase());

            List<Friend> billWasPaidFor = readFriendsForBillWasPaid(friends, scanner, billIndex);
            Bill bill = new Bill(amount, billType, billWasPaidFor, null);
            bills.add(bill);
        }
        return bills;
    }

    private List<Friend> readFriendsForBillWasPaid(List<Friend> friends, Scanner scanner, int billIndex) {
        System.out.println(enterNumberOfFriendsBill + (billIndex + one) + wasPaidFor);
        int paidForCount = scanner.nextInt();

        List<Friend> billWasPaidFor = new LinkedList<>();

        for (int paidForIndex = zero; paidForIndex < paidForCount; paidForIndex++) {
            System.out.println(enterFriendId);
            int friendId = scanner.nextInt();

            billWasPaidFor.add(friends.get(friendId));
        }
        return billWasPaidFor;
    }

    private void readFriendDetails(List<Friend> friends, Scanner scanner) {
        System.out.println(enterNumberOfFriends);
        int noOfFriends = scanner.nextInt();


        if (noOfFriends == zero) {
            System.out.println(invalidInputZeroFriendsErrorMessage);
            throw new RuntimeException(zeroFriendsErrorMessage);
        }
        for (int friendIndex = zero; friendIndex < noOfFriends; friendIndex++) {
            System.out.println(enterNameOfFriend + (friendIndex + one));
            String name = scanner.next();
            System.out.println(enterAmountPaid + name);
            Double amount = scanner.nextDouble();

            Friend friend = new Friend(name, amount, defaultAmountToPay);
            friends.add(friend);
        }
    }
}