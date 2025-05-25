public class ThreadCreation1 extends Thread{
    public void run() {
        System.out.println("INSIDE ThreadCreation1 run method & executed by Thread: "+Thread.currentThread().getName());
    }
}
