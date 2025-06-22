package semaphore;

public class SemaPhoreExampleMain {
    public static void main(String[] args) {

        SemaPhoreExample obj = new SemaPhoreExample();

        Thread th1 = new Thread(() -> obj.producer());
        Thread th2 = new Thread(() -> obj.producer());
        Thread th3 = new Thread(() -> obj.producer());
        Thread th4 = new Thread(() -> obj.producer());

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
