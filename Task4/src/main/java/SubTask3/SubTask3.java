package SubTask3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SubTask3 {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/file.txt");
        File writeInFile = new File("src/main/resources/OuterFile.txt");

        PrintWriter pw = new PrintWriter(writeInFile);

        Scanner scanner = new Scanner(file);
        List<String> list = new ArrayList<>();
        Stack<String> strings = new Stack<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }

        list.forEach(strings::push);

        while (!strings.empty()) {
            pw.println(strings.peek());
            strings.pop();
        }
        pw.close();
    }
}
