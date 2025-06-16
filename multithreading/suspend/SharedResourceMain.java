package suspend;

public class SharedResourceMain {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("Main Thread started..."+Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 is calling produce method..."+Thread.currentThread().getName());
            sharedResource.produce();
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread2 is calling produce method..."+Thread.currentThread().getName());
            sharedResource.produce();
        });
        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread is suspended");
        t1.suspend();//t2 will never go inside produce(). deadlock situation.

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //t1.resume();//resumes the suspended thread
        System.out.println("Main Thread finishing it's work ..."+Thread.currentThread().getName());
    }
}
