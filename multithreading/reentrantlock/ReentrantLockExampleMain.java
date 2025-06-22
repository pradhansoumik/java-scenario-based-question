package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExampleMain {
    public static void main(String[] args) {

        ReentrantLockExample obj1 = new ReentrantLockExample();
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread th1 = new Thread(() -> obj1.produce(reentrantLock));

        ReentrantLockExample obj2 = new ReentrantLockExample();
        Thread th2 = new Thread(() -> obj2.produce(reentrantLock));

        //Runnable task1 = () -> obj1.produce();
        //Runnable task2 = () -> obj2.produce();

        //Thread th1 = new Thread(task1,"Thread-1");
        //Thread th2 = new Thread(task2,"Thread-2");

        th1.start();
        th2.start();
    }

}
