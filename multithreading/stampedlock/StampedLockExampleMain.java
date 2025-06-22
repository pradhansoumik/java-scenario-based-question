package stampedlock;

public class StampedLockExampleMain {
    public static void main(String[] args) {

        StampedLockExample obj = new StampedLockExample();

        Thread th1 = new Thread(() -> obj.producer());
        Thread th2 = new Thread(() -> obj.consumer());

        th1.start();
        th2.start();
    }
}
