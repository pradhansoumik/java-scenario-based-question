package monitorlock;

public class SharedResourceMain {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
                try{
                    Thread.sleep(3000);
                }
                catch(Exception e){
                  //
                }
                sharedResource.addItem();});

        Thread consumerThread = new Thread(() -> sharedResource.consumeItem());

        producerThread.start();
        consumerThread.start();

    }
}
