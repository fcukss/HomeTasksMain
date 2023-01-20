package SubTask1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SubTask1 {
    public static final String input = ".." + File.separator + "data.txt";
    public static final String output = ".." + File.separator + "data_sorted.txt";

    public static void sort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            boolean is_sorted = true;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    is_sorted = false;
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
            if (is_sorted) {
                return;
            }
        }
    }

    public static StringBuilder readFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext())
            sb.append(scanner.nextInt()).append(" ");
        return sb;
    }


    public static void main(String[] args) throws FileNotFoundException {

        File fileInput = new File(input);
        File fileOutput = new File(output);
        PrintWriter pw = new PrintWriter(fileInput);
        PrintWriter pw2 = new PrintWriter(fileOutput);
        int[] numbers = new int[20];

        new Random().ints(20,0,50).forEach(pw::println);
        pw.close();

        String str = String.valueOf(readFromFile(fileInput));

        int count = 0;
        String[] strings = str.split(" ");
        for (String s : strings)
            numbers[count++] = Integer.parseInt(s);

        sort(numbers);

        for (int i : numbers)
            pw2.println(i);
        pw2.close();

        System.out.println("Input ==> " + readFromFile(fileInput));
        System.out.println("Output ==> " + readFromFile(fileOutput));

    }
}
