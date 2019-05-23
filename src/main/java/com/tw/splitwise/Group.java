package com.tw.splitwise;

import java.util.List;
import java.util.stream.Collectors;

//This class represents a group of friends having bills to settle
public class Group {
    private final List<Friend> friends;
    private final Charges charges;
    private static final int negativeOne = -1;

    public Group(List<Friend> friends) {
        this.friends = friends;
        this.charges = new PremiumGroupCharges();
    }

    public void settle(List<Bill> bills) {
        for (Bill bill : bills) {
            bill.settle();
        }
        this.findWhoPaysWhom(friends, bills);
    }

    private void findWhoPaysWhom(List<Friend> friends, List<Bill> bills) {
        List<Friend> payers = findPayers(friends);
        List<Friend> receivers = findReceivers(friends);

        sortPayersAndReceivers(payers, receivers);
        findWhoPaysHowMuchAmount(payers, receivers);

        if (friends.size() >= 5) {
            charges.calculate(friends, bills);
        }
    }

    private List<Friend> findPayers(List<Friend> friends) {
        return friends.stream().
                filter(friend -> friend.calculatePaidAndToPayDifference() < 0)
                .collect(Collectors.toList());
    }

    private List<Friend> findReceivers(List<Friend> friends) {
        return friends.stream().
                filter(friend -> friend.calculatePaidAndToPayDifference() > 0)
                .collect(Collectors.toList());
    }

    private void sortPayersAndReceivers(List<Friend> payers, List<Friend> receivers) {
        FriendComparator comparator = new FriendComparator();
        payers.sort(comparator);
        receivers.sort(comparator);
    }

    private void findWhoPaysHowMuchAmount(List<Friend> payers, List<Friend> receivers) {
        Integer payerIndex = 0, receiverIndex = 0;

        while (payerIndex < payers.size()) {
            Friend receiver = receivers.get(receiverIndex);
            Double amountToBeReceived = receiver.calculatePaidAndToPayDifference();

            Friend payer = payers.get(payerIndex);
            Double amountCanBePaid = payer.calculatePaidAndToPayDifference() * negativeOne;

            if (amountCanBePaid > amountToBeReceived) {
                payer.settleAmountWith(receiver, amountToBeReceived);
                receiverIndex++;
            } else if (amountToBeReceived > amountCanBePaid) {
                receiver.receiveAmountFrom(payer, amountCanBePaid);
                payerIndex++;
            } else {
                payer.addSettlementAmount(new SettlementAmount(amountCanBePaid, receiver));
                payerIndex++;
                receiverIndex++;
            }
        }
    }
}