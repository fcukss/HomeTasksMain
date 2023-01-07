package SubTask5;

import java.util.concurrent.Semaphore;

public class CallCenter {
    public static void main(String[] args) {

        Semaphore callCenter = new Semaphore(3);

        new Person("Oleg", callCenter);
        new Person("Ihor", callCenter);
        new Person("Anna", callCenter);
        new Person("Olya", callCenter);
        new Person("Serg", callCenter);
        new Person("Alex", callCenter);
        new Person("Bob", callCenter);
        new Person("Tom", callCenter);
    }
}
