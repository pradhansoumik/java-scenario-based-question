package futureCompletableFutureCallable;

import java.util.concurrent.*;

public class FutureExample2 {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 1, 10, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        Future<?> futureObj = threadPoolExecutor.submit(() -> {
            try{
                Thread.sleep(1000);
                System.out.println("Task Completed by: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Is Task Completed? : " + futureObj.isDone());

        try{
            //blocking call - main thread will wait till the task is completed
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException | InterruptedException | ExecutionException e){
            System.out.println("Timeout Exception ocurred.");
        }

        try{
            futureObj.get();
        }
        catch (Exception e){
            System.out.println("Exception occurred while getting the Future result: " + e.getMessage());
        }

        System.out.println("Is Task Completed? : " + futureObj.isDone());
        System.out.println("Is cancelled? : " + futureObj.isCancelled());
    }
}
