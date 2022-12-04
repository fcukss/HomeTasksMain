import java.util.Random;
import java.util.Scanner;

public class SubTask3 {

    static void guessTheNumber() {
        System.out.println("Введіть число: ");
        boolean res = true;
        Random random = new Random();
        int number = random.nextInt(100);

        Scanner scanner = new Scanner(System.in);
        while (res) {
            int numberGuess = scanner.nextInt();
            if (numberGuess == number) {
                System.out.println("Молодець!");
                res = false;
            } else if (numberGuess > number) {
                System.out.println("Багато");
            } else {
                System.out.println("Меньше");
            }
        }
    }


    public static void main(String[] args) {

        guessTheNumber();

    }
}
