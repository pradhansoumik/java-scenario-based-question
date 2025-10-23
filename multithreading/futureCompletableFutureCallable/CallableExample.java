package futureCompletableFutureCallable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableExample {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 2, 10, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        System.out.println("+++++++++++++++ USE CASE :: 1 +++++++++++++++");
        //use case - 1:
        //with runnable
        Future<?> futureObj = threadPoolExecutor.submit(() -> {
            System.out.println("Task1 with only Runnable: " + Thread.currentThread().getName());
        });

        try{
            Object object = futureObj.get();
            System.out.println(object == null);
        }
        catch (Exception e){
            System.out.println("Exception occurred while getting the Future result: " + e.getMessage());
        }

        System.out.println("+++++++++++++++ USE CASE :: 2 +++++++++++++++");
        //use case - 2:
        //with runnable and result
        var output = new ArrayList<>();
        Future<ArrayList<Object>> futureObj2 = threadPoolExecutor.submit(() -> {
            System.out.println("Task2 with Runnable + result : " + Thread.currentThread().getName());
            output.add(100);
        }, output);

        try {
            ArrayList<Object> result = futureObj2.get();
            System.out.println("Output List: " + result);
        } catch (Exception e) {
            System.out.println("Exception occurred while getting the Future result: " + e.getMessage());
        }

        System.out.println("+++++++++++++++ USE CASE :: 3 +++++++++++++++");
        //use case - 3:
        //callable
        Future<ArrayList<Object>> futureObj3 = threadPoolExecutor.submit(() -> {
            System.out.println("Task-3 with callable: " + Thread.currentThread().getName());
            var list = new ArrayList<>();
            list.add("callable task");
            return list;
        });

        try{
            ArrayList<Object> objects = futureObj3.get();
            System.out.println("Output: "+objects);
        } catch (Exception e) {
            System.out.println();
        }

        threadPoolExecutor.shutdown();
    }
}
