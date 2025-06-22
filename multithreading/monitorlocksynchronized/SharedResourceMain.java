package monitorlocksynchronized;

public class SharedResourceMain {
    public static void main(String[] args) {

        /*SharedResource sharedResource = new SharedResource();

        Thread th1 = new Thread(sharedResource::produce);
        Thread th2 = new Thread(sharedResource::produce);

        th1.start();
        th2.start();*/

        SharedResource sharedResourceObj1 = new SharedResource();
        Thread th1 = new Thread(sharedResourceObj1::produce);

        SharedResource sharedResourceObj2 = new SharedResource();
        Thread th2 = new Thread(sharedResourceObj2::produce);

        th1.start();
        th2.start();

    }
}
