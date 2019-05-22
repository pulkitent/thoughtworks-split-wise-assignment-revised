import com.tw.splitwise.*;
import com.tw.io.*;

import java.io.IOException;
import java.util.*;

import static com.tw.io.Constant.enterChoiceMessage;
import static com.tw.io.Constant.fileReaderChoice;

public class SplitWise {

    public static void main(String[] arg) throws IOException {
        List<Friend> friends = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        System.out.println(enterChoiceMessage);

        int choice = scanner.nextInt();
        if (choice == fileReaderChoice) {
            reader = new TextFileReader();
        }

        List<Bill> bills = reader.read(friends);

        Group group = new Group(bills);
        group.settleBills(friends);

        writer.write(friends);
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

        Bill bill1 = new Bill(100.0, BillType.FOOD, firstBillPaidFor, expenseRatioForBill1);
        Bill bill2 = new Bill(500.0, BillType.CAB, secondBillPaidFor, expenseRatioForBill2);
        Bill bill3 = new Bill(300.0, BillType.MOVIE, thirdBillPaidFor, expenseRatioForBill3);

        List<Bill> bills = new LinkedList<>();
        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);

        return bills;
    }
}