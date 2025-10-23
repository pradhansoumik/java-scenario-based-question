package futureCompletableFutureCallable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CompletableFutureExample {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 2, 2, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        //1st use case:
        try {
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                return "CompletableFuture supplyAsync";
            }, threadPoolExecutor);

            System.out.println(asyncTask1.get());
        }
        catch (Exception e) {
            System.out.println("Exception occurred while getting the CompletableFuture result: " + e.getMessage());

        }
        //2nd use case:
        try{
            CompletableFuture<String> asyncTask2 = CompletableFuture
                    .supplyAsync( () -> {
                                    return "CompletableFuture supplyAsync started for use case 2";
                            }, threadPoolExecutor)
                    .thenApply(result -> {
                        return result + " - processed in thenApply";
                    })
                    .thenApply(result -> {
                        return result + " - further processed in another thenApply";
                    })
                    .thenApply(result -> {
                        return result + " - final processing in last thenApply";
                    });

            System.out.println(asyncTask2.get());
        }
        catch (Exception e) {
            System.out.println("Exception occurred while getting the CompletableFuture result: " + e.getMessage());
        }

        //3rd use case:
        try {

            CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync( () -> {
                return "CompletableFuture supplyAsync started for use case 3";
            }, threadPoolExecutor)
                    .thenApplyAsync( result -> {
                        return result + " - executed in thread: " + Thread.currentThread().getName();
                    })
                    .thenApplyAsync( result -> {
                        return result + " - executed in thread: " + Thread.currentThread().getName();
                    })
                    .thenApplyAsync( result -> {
                        return result + " - executed in thread: " + Thread.currentThread().getName();
                    })
                    .thenApplyAsync( result -> {
                                return result + " - executed in thread: " + Thread.currentThread().getName();
                    })
                    .thenApplyAsync( result -> {
                        return result + " - executed in thread: " + Thread.currentThread().getName();
                    });
            System.out.println("Thread Name after CF: "+ Thread.currentThread().getName());

            System.out.println(asyncTask3.get());

        }
        catch (Exception ex){
            System.out.println("Exception occurred while executing the CompletableFuture: " + ex.getMessage());
        }

    }
}
