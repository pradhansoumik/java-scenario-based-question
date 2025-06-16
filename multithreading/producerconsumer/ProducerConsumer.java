package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public ProducerConsumer(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }
    public synchronized void produce(int item){
        //if the buffer size is full, wait for the consumer to consumes the item
        while(sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is full, Producer is waiting for Consumer");
            try {
                wait();//release all the monitor lock;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            sharedBuffer.add(item);
            System.out.println("Produced: "+item);
            //Notify the consumer that there are items to be consumed
            notify();//if any thread is waiting for ProducerConsumer object, it will invoke.
    }
    public synchronized int consume(int item){
        //if Queue is empty, wait for the producer to produce the item
        while(sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, Consumer is waiting for Producer");
            try {
                wait();//release all the monitor lock;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        sharedBuffer.poll();
        System.out.println("Consumed: "+item);
        //Notify the producer that there is space in the buffer now
        notify();
        return item;
    }
}
