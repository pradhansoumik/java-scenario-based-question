package threadLocalAndVirtualThread;

/**
 * ThreadLocal Example to show that each thread has its own copy of ThreadLocal variable
 */
public class ThreadLocalExample1 {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        //main thread
        threadLocal.set(Thread.currentThread().getName() + " - Main Thread Value");

        Thread thread1 = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Inside Thread1 - "+threadLocal.get());
        });

        thread1.start();

        try{
            Thread.sleep(1000);
        }
        catch(Exception ex)
        {

        }

        System.out.println("Inside Main Thread: " + threadLocal.get());
    }
}
