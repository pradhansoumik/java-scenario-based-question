package readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExampleMain {
    public static void main(String[] args) {

        ReadWriteLockExample obj1 = new ReadWriteLockExample();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> obj1.producer(readWriteLock));
        Thread th2 = new Thread(() -> obj1.producer(readWriteLock));

        ReadWriteLockExample obj2 = new ReadWriteLockExample();
        Thread th3 = new Thread(() -> obj2.consumer(readWriteLock));

        th1.start();
        th2.start();
        th3.start();
    }
}
