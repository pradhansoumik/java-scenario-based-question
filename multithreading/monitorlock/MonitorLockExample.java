package monitorlock;

public class MonitorLockExample {

    public synchronized void task1(){
        try {
            System.out.println("inside task1.");
            Thread.sleep(10000);//it doesn't release monitor lock.
            System.out.println("task1 completed.");
        }
        catch (Exception ex){
            //handle the Exception
        }
    }
    public void task2(){
        System.out.println("inside task2 before synchronized block.");
        synchronized (this){
            System.out.println("inside task2 after synchronized block.");
        }
    }
    public void task3(){
        System.out.println("inside task3.");
    }

}
