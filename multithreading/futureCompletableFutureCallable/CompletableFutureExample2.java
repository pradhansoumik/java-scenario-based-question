package futureCompletableFutureCallable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CompletableFutureExample2 {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 2, 2, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        //4th use case:
        try{
            CompletableFuture<String> asyncTask4 = CompletableFuture
                    .supplyAsync( () -> {
                        System.out.println("Thread name which runs 'supplyAsync': " + Thread.currentThread().getName());
                        return "CompletableFuture supplyAsync started for use case 2";
                        }, threadPoolExecutor)
                    .thenCompose( result -> {
                        return CompletableFuture.supplyAsync( () -> {
                            System.out.println("Thread name which runs nested 'supplyAsync' inside thenCompose: " + Thread.currentThread().getName());
                            return result + " :: thenCompose executed";
                        });
                    });
        }
        catch (Exception e) {
            System.out.println("Exception occurred while getting the CompletableFuture result: " + e.getMessage());
        }

        //use case - 5: then accept
        try{
            CompletableFuture<Void> asyncTask5 = CompletableFuture
                    .supplyAsync( () -> {
                        System.out.println("Thread name which runs 'supplyAsync': " + Thread.currentThread().getName());
                        return "CompletableFuture supplyAsync started for use case 5";
                    }, threadPoolExecutor)
                    .thenAccept( result -> {
                        System.out.println("Thread name which runs 'thenAccept': " + Thread.currentThread().getName());
                        System.out.println("Result received in thenAccept: " + result);
                    });
        }
        catch (Exception e) {
            System.out.println("Exception occurred while getting the CompletableFuture result: " + e.getMessage());
        }

        //then combine & then combine async
        try{
            CompletableFuture<Integer> asyncTask6 = CompletableFuture.supplyAsync(
                    () -> {
                        System.out.println("Thread name which runs 'supplyAsync' for asyncTask6: " + Thread.currentThread().getName());
                        return 10;
                    }, threadPoolExecutor

            );
            CompletableFuture<String> asyncTask7 = CompletableFuture.supplyAsync(
                    () -> {
                        System.out.println("Thread name which runs 'supplyAsync' for asyncTask7: " + Thread.currentThread().getName());
                        return "Hello ";
                    }, threadPoolExecutor

            );

            CompletableFuture<String> stringCompletableFuture = asyncTask6.thenCombine(asyncTask7, (num, str) -> {
                String result = str + num;
                System.out.println("Result of thenCombine: " + result + " | Thread: " + Thread.currentThread().getName());
                return result;
            });
            System.out.println("-----------------------------------");
            System.out.println(stringCompletableFuture.get());
        }
        catch(Exception e){

        }

    }
}
