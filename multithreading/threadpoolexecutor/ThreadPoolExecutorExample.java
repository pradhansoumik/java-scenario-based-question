package threadpoolexecutor;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10)
                , new CustomThreadFactory(), new CustomRejectedExecutionHandler()
        );

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(() -> {
                try{
                    Thread.sleep(2000);
                    System.out.println("Current Thread Name: " + Thread.currentThread().getName());
                }
                catch (Exception e){
                }
            });
        }
        threadPoolExecutor.shutdown();
    }


}
class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {

        return new Thread(r);
    }
}
class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task " + r.toString() +
                " rejected from " +
                executor.toString());
    }

}
