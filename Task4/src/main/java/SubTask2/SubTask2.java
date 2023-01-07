package SubTask2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class SubTask2 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/file2.txt");
        PrintWriter pw = new PrintWriter(file);

        List<Integer> numbers = new ArrayList<>();
        new Random().ints(10, 1, 9).forEach(numbers::add);
        System.out.println(numbers);
        Collections.sort(numbers);
        for(Integer n: numbers)
            pw.print(n);
        pw.close();
        System.out.println(numbers);
    }
}
