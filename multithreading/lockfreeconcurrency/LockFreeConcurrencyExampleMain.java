package lockfreeconcurrency;

public class LockFreeConcurrencyExampleMain {

    public static void main(String[] args) {

        LockFreeConcurrencyExample obj = new LockFreeConcurrencyExample();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                //obj.increment();
                obj.increment1();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                //obj.increment();
                obj.increment1();
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (Exception ex){

        }
        //System.out.println(obj.getCounter());
        System.out.println(obj.getCounter1());
    }
}
