package lockfreeconcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFreeConcurrencyExample {
    private AtomicInteger counter = new AtomicInteger(0);
    private int counter1;

    public int getCounter(){
        return counter.get();
    }
    public void increment(){
        counter.incrementAndGet();
    }

    /**
     * might be some data loss
     */
    public int getCounter1(){
        return counter1;
    }
    public void increment1(){
        counter1++;
    }
}
