package SubTask5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Person extends Thread {
    String name;
    private Semaphore callCenter;

    public Person(String name, Semaphore callCenter) {
        this.name = name;
        this.callCenter = callCenter;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s wait \n", name);
            callCenter.acquire();
            System.out.printf("%s speaking with operator \n", name);
            sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            System.out.printf("%s end call \n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            callCenter.release();
        }
    }
}
