package SubTask2;

public class SubTask2 {
    public static void main(String[] args) throws InterruptedException {
        new ThreadOne();
        Thread.sleep(2000);
        new ThreadTwo();
    }
}

class ThreadOne extends Thread{
    public ThreadOne() {
        start();
    }

    @Override
    public void run() {
        try {
            for( int i=0; i<4; i++){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class  ThreadTwo implements Runnable{
    public ThreadTwo() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            for( int i=0; i<4; i++){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}