package com.tw.io;

import com.tw.splitwise.Bill;
import com.tw.splitwise.BillType;
import com.tw.splitwise.Friend;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("Enter number of Bills");
        int noOfBills = scanner.nextInt();

        for (int billIndex = 0; billIndex < noOfBills; billIndex++) {
            System.out.println("Enter the amount for bill " + (billIndex + 1));
            Double amount = scanner.nextDouble();
            System.out.println("Enter the type of bill");
            String type = scanner.next();

            List<Friend> billWasPaidFor = readFriendsForBillWasPaid(friends, scanner, billIndex);
            Bill bill = new Bill(amount, BillType.valueOf(type.toUpperCase()), billWasPaidFor, null);
            bills.add(bill);
        }
        return bills;
    }

    private List<Friend> readFriendsForBillWasPaid(List<Friend> friends, Scanner scanner, int billIndex) {
        System.out.println("Enter number of friends bill " + (billIndex + 1) + " was paid for");
        int paidForCount = scanner.nextInt();

        List<Friend> billWasPaidFor = new LinkedList<>();

        for (int paidForIndex = 0; paidForIndex < paidForCount; paidForIndex++) {
            System.out.println("Enter the friend id (Starting from 0)");
            int friendId = scanner.nextInt();

            billWasPaidFor.add(friends.get(friendId));
        }
        return billWasPaidFor;
    }

    private void readFriendDetails(List<Friend> friends, Scanner scanner) {
        System.out.println("Enter number of friends involved in the trip");
        int noOfFriends = scanner.nextInt();

        for (int friendIndex = 0; friendIndex < noOfFriends; friendIndex++) {
            System.out.println("Enter the name of friend no " + (friendIndex + 1));
            String name = scanner.next();
            System.out.println("Enter the amount paid by " + name);
            Double amount = scanner.nextDouble();

            Friend friend = new Friend(name, amount, 0.0);
            friends.add(friend);
        }
    }
}