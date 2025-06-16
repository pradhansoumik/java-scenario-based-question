package monitorlock;

public class Task1MonitorLock implements Runnable{
    MonitorLockExample monitorLockExample;

    public Task1MonitorLock(MonitorLockExample obj){
        this.monitorLockExample = obj;
    }

    @Override
    public void run() {
        monitorLockExample.task1();
    }
}
