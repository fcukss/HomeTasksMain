package SubTask2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubTask2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/JavaProgram.java");
        Scanner scanner = new Scanner(file);
        List<StringBuilder> list;
        List<String> stringList = new ArrayList<>();

        while (scanner.hasNext()) {
            stringList.add(scanner.nextLine());
        }
        list = stringList.stream().map(StringBuilder::new).collect(Collectors.toList());

        String s = "public";
        String p = "private";

        for (StringBuilder str : list) {
            if (str.toString().contains(s)) {
                int a = str.indexOf(s);
                int b = a + s.length();
                str.replace(a, b, p);
            }
        }

        PrintWriter pw = new PrintWriter(file);
        for (StringBuilder str : list) {
            pw.print(str.toString());
        }
        pw.close();

    }
}
