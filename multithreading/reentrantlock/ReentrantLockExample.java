package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    //ReentrantLock reentrantLock = new ReentrantLock();
    private boolean isAvailable = false;
    public void produce(ReentrantLock lock){

        lock.lock();

        try {
            //boolean lockAcquired = lock.tryLock();
            //if(lockAcquired) {
                System.out.println("lock is acquired by " + Thread.currentThread().getName());
                isAvailable = true;
                //System.out.println("Lock hash: " + reentrantLock.hashCode());
                //Thread.sleep(8000);
            //}
//            else{
//               System.out.println("inside ELSE");
//            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally{
            lock.unlock();
            System.out.println("lock is released by "+Thread.currentThread().getName());
        }
    }
}
