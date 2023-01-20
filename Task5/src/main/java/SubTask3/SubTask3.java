package SubTask3;

public class SubTask3 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("not synchronized");
        Count count = new Count();
        Thread thread1 = new Thread(new MyRunnable(count));
        Thread thread2 = new Thread(new MyRunnable(count));
        Thread thread3 = new Thread(new MyRunnable(count));
        Thread thread4 = new Thread(new MyRunnable(count));
        Thread thread5 = new Thread(new MyRunnable(count));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        Thread.sleep(2000);

        System.out.println("--------------------------------------------------");
        System.out.println("synchronized");
        Count count2 = new Count();
        Thread thread10 = new Thread(new MyRunnable2(count2));
        Thread thread11 = new Thread(new MyRunnable2(count2));
        Thread thread12 = new Thread(new MyRunnable2(count2));
        Thread thread13 = new Thread(new MyRunnable2(count2));

        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();

        thread10.join();
        thread11.join();
        thread12.join();
        thread13.join();

    }
}

class Count {
    int countOne = 0;
    int countTwo = 0;

    void increment() {
        try {
            if (countOne < countTwo)
                System.out.println("лічильник 2 = " + countTwo +  " більше лічильника 1 = " + countOne);
            else if (countOne > countTwo)
                System.out.println("лічильник 1 = " + countOne+ " більше лічильника 2 = " + countTwo);
            else
                System.out.println("лічильникі однакові");
            countOne += 10;
            Thread.sleep(10);
            countTwo += 20;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable implements Runnable {
    Count count;;

    public MyRunnable(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.increment();
    }
}

class MyRunnable2 implements Runnable {
    final Count count;

    public MyRunnable2(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            count.increment();
        }
    }
}