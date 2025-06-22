package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;

public class SemaPhoreExample {

    private boolean isAvailable = false;
    Semaphore semaphore = new Semaphore(2);
    public void producer(){
        try{
            semaphore.acquire(2);
            System.out.println("lock is acquired by " + Thread.currentThread().getName());
            isAvailable = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release(2);
            System.out.println("lock is released by " + Thread.currentThread().getName());
        }
    }
}
