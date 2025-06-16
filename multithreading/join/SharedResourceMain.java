package join;

public class SharedResourceMain {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("Main Thread started..."+Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 is calling produce method..."+Thread.currentThread().getName());
            sharedResource.produce();
        });

        t1.start();
        try {
            System.out.println("Main Thread is waiting for current thread to finish it's work");
            t1.join();//main thread will be waiting till t1 finished it's work
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread finishing it's work ..."+Thread.currentThread().getName());
    }
}
