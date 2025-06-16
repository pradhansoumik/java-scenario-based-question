package join;

public class SharedResource {
    public boolean isAvailable = false;

    public synchronized void produce(){
        System.out.println("inside produce method => lock acquired by "+Thread.currentThread().getName());
        try {
            Thread.sleep(8000);//it doesn't release the lock.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("inside produce method => lock released by "+Thread.currentThread().getName());
    }
}
