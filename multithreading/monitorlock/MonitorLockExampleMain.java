package monitorlock;

public class MonitorLockExampleMain {
    public static void main(String[] args) {

        MonitorLockExample monitorLockExample = new MonitorLockExample();

        //without lambda
        Task1MonitorLock task1MonitorLock = new Task1MonitorLock(monitorLockExample);
        Thread t1 = new Thread(task1MonitorLock);

        //lambda expression
        //Thread t1 = new Thread(() -> monitorLockExample.task1());
        Thread t2 = new Thread(() -> monitorLockExample.task2());
        Thread t3 = new Thread(() -> monitorLockExample.task3());

        t1.start();
        t2.start();
        t3.start();
    }
}
