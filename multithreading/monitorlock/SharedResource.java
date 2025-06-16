package monitorlock;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("Procducer thread is calling the notify method");
        notifyAll();
    }
    public synchronized void consumeItem(){

        System.out.println("Consumer thread inside consumeItem method ...");
        if(!isItemPresent){//item is not present so it will wait
            try{
                System.out.println("Consumer thread is waiting ...");
                wait();// it releases all the monitor lock.
            }
            catch (Exception exception){
                //exception handling here
            }
        }
        System.out.println("Consumer thread consumed the item");
        isItemPresent = false;
    }
}
