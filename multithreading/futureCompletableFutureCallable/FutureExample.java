package futureCompletableFutureCallable;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class FutureExample {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 1, 10, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        //with this the program will terminate after 10 secs as mentioned in keepAliveTime
        //without this the program will keep running as core threads are not timed out by default
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        //new thread will be created & it will execute the task!
        Future<?> futureObj = threadPoolExecutor.submit(() -> {
            System.out.println("Task Completed by: " + Thread.currentThread().getName());
        });

        //main thread will continue processing ...

        //to get the result of an Async task ...
        System.out.println("Is Task Completed? : " + futureObj.isDone());
    }
}
