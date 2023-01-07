package SubTask4;

import java.util.*;

public class SubTask4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        try {
            int num = scanner.nextInt();
            while (num > 0) {
                stack.add(num % 10);
                num /= 10;
            }
        } catch (InputMismatchException e) {
            System.out.println("ввели некорректные данне");
        }
        stack.stream().map(i -> i + "").forEach(System.out::print);

    }
}
