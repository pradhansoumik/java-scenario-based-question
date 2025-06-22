package monitorlocksynchronized;

public class SharedResource {

    private boolean isAvailable = false;

    public synchronized void produce(){
        System.out.println("lock acquired by "+Thread.currentThread().getName());
        try {
            isAvailable = true;
            System.out.println("inside synchronized produce() before sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("lock released by "+Thread.currentThread().getName());

    }


}
