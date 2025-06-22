package stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    int a = 10;
    StampedLock stampedLock = new StampedLock();

    public void producer(){
        long stamp = stampedLock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic Read");
            a = 11;
            Thread.sleep(6000);
            if(stampedLock.validate(stamp)){
                System.out.println("Updated value successfully");
            }
            else{
                System.out.println("Rollback of work");
                a = 10;
            }
        }
        catch(Exception ex){
            //
        }
    }
    public void consumer(){
        long stamp = stampedLock.writeLock();
        System.out.println("Lock is acquired by: "+Thread.currentThread().getName());
        try{
            System.out.println("Performing work");
            a = 9;
        }
        finally{
            stampedLock.unlockWrite(stamp);
            System.out.println("Lock is released by: "+Thread.currentThread().getName());
        }
    }

}
