package com.tw.expensify;

import java.util.*;

class Friend implements Comparator<Friend> {
    private final String Name;
    private Integer amountToPay;
    private final Integer amountPaid;
    final List<Amount> amounts;

    Friend(String name, Integer amountPaid, Integer amountToPay) {
        this.Name = name;
        this.amountPaid = amountPaid;
        this.amountToPay = amountToPay;
        this.amounts = new LinkedList<>();
    }

    void settleAmount(int amount) {
        this.amountToPay += amount;
    }

    void findWhoPaysWhom(List<Friend> friends) {
        List<Friend> payers = findPayers(friends);
        List<Friend> receivers = findReceivers(friends);

        sortPayersAndReceivers(payers, receivers);
        findWhichPayerHasToPayHowMuch(payers, receivers);
    }

    @Override
    public String toString() {
        return this.Name;
    }

    @Override
    public int compare(Friend friend, Friend anotherFriend) {
        int finalAmount = Math.abs(friend.amountPaid - friend.amountToPay);
        int anotherFinalAmount = Math.abs(anotherFriend.amountPaid - anotherFriend.amountToPay);

        return finalAmount - anotherFinalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(Name, friend.Name) &&
                Objects.equals(amountToPay, friend.amountToPay) &&
                Objects.equals(amountPaid, friend.amountPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, amountToPay, amountPaid);
    }

    private void sortPayersAndReceivers(List<Friend> payers, List<Friend> receivers) {
        Friend temporaryFriend = new Friend("Temp", 0, 0);
        payers.sort(temporaryFriend);
        receivers.sort(temporaryFriend);
    }

    private List<Friend> findPayers(List<Friend> friends) {
        List<Friend> payers = new LinkedList<>();

        for (Friend friend : friends) {
            if (friend.amountPaid - friend.amountToPay < 0) {
                payers.add(friend);
            }
        }

        return payers;
    }

    private List<Friend> findReceivers(List<Friend> friends) {
        List<Friend> receivers = new LinkedList<>();

        for (Friend friend : friends) {
            if (friend.amountPaid - friend.amountToPay > 0) {
                receivers.add(friend);
            }
        }

        return receivers;
    }

    private void findWhichPayerHasToPayHowMuch(List<Friend> payers, List<Friend> receivers) {
        int payerIndex = 0, receiverIndex = 0;

        while (payerIndex < payers.size()) {
            Friend receiver = receivers.get(receiverIndex);
            int amountToBeReceived = receiver.amountPaid - receiver.amountToPay;

            Friend payer = payers.get(payerIndex);
            int amountCanBePaid = payer.amountToPay - payer.amountPaid;

            if (amountCanBePaid > amountToBeReceived) {
                payer.amountToPay = payer.amountToPay - amountToBeReceived;
                payer.amounts.add(new Amount(amountToBeReceived, receiver));
                receiverIndex++;
            } else if (amountToBeReceived > amountCanBePaid) {
                receiver.amountToPay = receiver.amountToPay - amountCanBePaid;
                payer.amounts.add(new Amount(amountCanBePaid, receiver));
                payerIndex++;
            } else {
                payer.amounts.add(new Amount(amountCanBePaid, receiver));
                payerIndex++;
                receiverIndex++;
            }
        }
    }
}