package readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLockExample {

    private boolean isAvailable = false;
    public void producer(ReadWriteLock readWriteLock){
        try{
            readWriteLock.readLock().lock();//shared lock
            System.out.println("lock is acquired by " + Thread.currentThread().getName());
            //isAvailable = true;
            //Thread.sleep(5000);
        }
        catch(Exception ex){
            //Handle the Exception
        }
        finally {
            readWriteLock.readLock().unlock();
            System.out.println("lock is released by " + Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock readWriteLock){
        try{
            readWriteLock.writeLock().lock();//exclusive lock
            System.out.println("lock is acquired by " + Thread.currentThread().getName());
            isAvailable = false;
        }
        catch(Exception ex){
            //Handle the Exception
        }
        finally {
            readWriteLock.writeLock().unlock();
            System.out.println("lock is released by " + Thread.currentThread().getName());
        }

    }

}
