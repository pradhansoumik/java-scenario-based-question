package threadLocalAndVirtualThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {
    public static void main(String[] args) {

        //currently my machine is compatible with java 17 version but
        // Virtual threads are introduced in java 19 version.

        //one way
        //Thread virtualThread = Thread.ofVirtual().start(Runnable task);

        //another way
        //ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        //executorService.submit(Runnable task);
    }
}
