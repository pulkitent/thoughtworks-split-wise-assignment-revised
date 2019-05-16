import com.tw.splitwise.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SplitWise {
    public static void main(String[] arg) {
        List<Friend> friends = new LinkedList<>();

        Bills bills = new Bills(createBills(friends));
        bills.settle(friends);

        for (Friend friend : friends) {
            for (SettlementAmount settlementAmount : friend.getSettlementAmount()) {
                System.out.println(friend + " has to pay " + settlementAmount);
            }
        }
    }

    private static List<Bill> createBills(List<Friend> friends) {
        Friend friend1 = new Friend("Pulkit", 100.0, 0.0);
        Friend friend2 = new Friend("Abhishek", 500.0, 0.0);
        Friend friend3 = new Friend("Ravinder", 0.0, 0.0);
        Friend friend4 = new Friend("Charan", 300.0, 0.0);

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);

        List<Friend> firstBillPaidFor = new LinkedList<>();
        firstBillPaidFor.add(friend1);
        firstBillPaidFor.add(friend2);
        firstBillPaidFor.add(friend3);
        firstBillPaidFor.add(friend4);

        List<Friend> secondBillPaidFor = new LinkedList<>();
        secondBillPaidFor.add(friend3);
        secondBillPaidFor.add(friend4);

        List<Friend> thirdBillPaidFor = new LinkedList<>();
        thirdBillPaidFor.add(friend1);
        thirdBillPaidFor.add(friend2);

        Map<Friend, Double> expenseRatioForBill1 = new HashMap<>();
        Map<Friend, Double> expenseRatioForBill2 = new HashMap<>();
        Map<Friend, Double> expenseRatioForBill3 = new HashMap<>();

        expenseRatioForBill2.put(friend3, 0.60);
        expenseRatioForBill2.put(friend4, 0.40);

        Bill bill1 = new Bill(100.0, BillType.FOOD, friend1, firstBillPaidFor, expenseRatioForBill1);
        Bill bill2 = new Bill(500.0, BillType.CAB, friend2, secondBillPaidFor, expenseRatioForBill2);
        Bill bill3 = new Bill(300.0, BillType.MOVIE, friend4, thirdBillPaidFor, expenseRatioForBill3);

        List<Bill> bills = new LinkedList<>();
        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);

        return bills;
    }
}