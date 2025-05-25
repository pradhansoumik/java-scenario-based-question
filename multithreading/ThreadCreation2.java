public class ThreadCreation2 implements Runnable{
    @Override
    public void run() {
        System.out.println("INSIDE ThreadCreation2 run method & executed by Thread: "+Thread.currentThread().getName());
    }

}
