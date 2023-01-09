package SubTask3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SubTask3 {


    public static long testWithArrayList(int N) {

        List<Person> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(new Person(i));
        }

        long t1 = System.currentTimeMillis();
        while (list.size() > 1) {
            for (int i = 1; i < list.size(); i = i + 2) {
                list.remove(i);
            }
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    public static long testWithLinkedList(int N) {

        List<Person> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(new Person(i));
        }

        long t1 = System.currentTimeMillis();
        while (list.size() > 1) {
            for (int i = 1; i < list.size(); i = i + 2) {
                list.remove(i);
            }
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of Persons: ");
        int N = scanner.nextInt();

        System.out.printf("ArrayList worked = %d msec\n",testWithArrayList(N));
        System.out.printf("LinkedList worked = %d msec\n",testWithLinkedList(N));

    }
}


class Person {
    private int number;

    public Person(int number) {
        this.number = number;
    }
}