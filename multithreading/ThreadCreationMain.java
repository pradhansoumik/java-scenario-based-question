public class ThreadCreationMain {
    public static void main(String[] args) {
        System.out.println("Process is started with "+ Thread.currentThread().getName()+" Thread");
        ThreadCreation2 threadCreation2 = new ThreadCreation2();
        Thread thread = new Thread(threadCreation2);//Thread created
        thread.start();//new Thread started & JVM schedules new Thread
        thread.run();//NO new Thread will be created! it acts like normal method call.

        ThreadCreation1 threadCreation1 = new ThreadCreation1();//Thread created
        threadCreation1.start();//new Thread started & JVM schedules new Thread
        threadCreation1.run();//NO new Thread will be created! it acts like normal method call.
        System.out.println("Finished main Thread: "+Thread.currentThread().getName());
    }
}
