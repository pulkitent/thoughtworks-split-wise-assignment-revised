import com.tw.splitwise.*;
import com.tw.io.*;

import java.io.IOException;
import java.util.*;

import static com.tw.splitwise.Constant.enterChoiceMessage;
import static com.tw.splitwise.Constant.fileReaderChoice;

public class SplitWise {

    public static void main(String[] arg) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        System.out.println(enterChoiceMessage);

        int choice = scanner.nextInt();
        if (choice == fileReaderChoice) {
            reader = new TextFileReader();
        }

        List<Friend> friends = new LinkedList<>();
        Group group = new Group(friends);

        List<Bill> bills = reader.read(friends);
        group.settle(bills);

        writer.write(friends);
    }
}