import com.tw.splitwise.*;
import com.tw.io.*;

import java.util.*;

import static com.tw.io.Constant.wrongInputErrorMessage;
import static com.tw.splitwise.Constant.*;

//This class is the main application startup class
public class SplitWise {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        System.out.println(enterChoiceMessage);

        int choice = scanner.nextInt();
        if (choice == fileReaderChoice) {
            reader = new TextFileReader();
        }

        List<Friend> friends = new LinkedList<>();
        Charges charges = new PremiumGroupCharges(splitwiseRate);
        Group group = new Group(friends, charges);

        try {
            List<Bill> bills = reader.read(friends);
            group.settle(bills);
            writer.write(friends);
        } catch (Exception ex) {
            System.out.println(wrongInputErrorMessage);
        }
    }
}