package threadLocalAndVirtualThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Remember to clean up ThreadLocal variables to prevent memory leaks!
 * If the pool has only 1 thread, all 10 tasks run on the same thread, which already has the ThreadLocal value set. So you get the same output 10 times.
 *
 * If the pool has 2–5 threads, some tasks may run on threads that never had threadLocal.set() called, so threadLocal.get() returns null for those.
 */
public class ThreadLocalExample2 {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ExecutorService pool = Executors.newFixedThreadPool(1);

        //without remove
        pool.submit(() ->{
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Inside pool thread single task: " + threadLocal.get());
        });

        System.out.println("-----------------------------------");

        for(int i = 1; i <= 10; i++){
            pool.submit(() -> System.out.println("Inside pool thread: " + threadLocal.get()));
        }
        pool.shutdown();

        //with remove
        pool.submit(() ->{
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Inside pool thread single task: " + threadLocal.get());
            threadLocal.remove();
        });
        for(int i = 1; i <= 10; i++){
            pool.submit(() -> System.out.println("Inside pool thread: " + threadLocal.get()));
        }
        pool.shutdown();
    }
}
