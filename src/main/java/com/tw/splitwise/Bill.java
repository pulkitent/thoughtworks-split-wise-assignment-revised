package com.tw.splitwise;

import java.util.List;
import java.util.Map;

import static com.tw.splitwise.Constant.*;

//This class represents statement of the money owed for services
public class Bill {
    private final Double amount;
    private final BillType type;
    private final List<Friend> paidFor;
    private final Map<Friend, Double> expenseRatio;

    public Bill(Double amount, BillType type, List<Friend> paidFor, Map<Friend, Double> expenseRatio) {
        this.amount = amount;
        this.type = type;
        this.paidFor = paidFor;
        this.expenseRatio = expenseRatio;
    }

    void settle() {
        int friendsCount = paidFor.size();
        for (Friend friend : this.paidFor) {
            Double ratio = findExpenseRatio(friend);
            double perFriendAmount = ratio * this.amount;

            if (Double.compare(ratio, defaultExpenseRatio) == zero) {
                perFriendAmount = perFriendAmount / friendsCount;
            }

            friend.updateAmountToPay(perFriendAmount);
        }
    }

    private Double findExpenseRatio(Friend friend) {
        if (this.expenseRatio == null)
            return defaultExpenseRatio;
        return expenseRatio.getOrDefault(friend, defaultExpenseRatio);
    }

    static Double findTotalAmount(List<Bill> bills) {
        Double amount = zeroPrecision;
        for (Bill bill : bills) {
            amount += bill.amount;
        }
        return amount;
    }
}