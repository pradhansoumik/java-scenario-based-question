package producerconsumer;

public class ProducerConsumerMain {

    public static void main(String[] args) {
        int bufferSize = 3;
        ProducerConsumer pcThread = new ProducerConsumer(bufferSize);

        Thread producerThread = new Thread(() -> {
            for(int i = 1; i<=6; i++){
               pcThread.produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i = 1; i<=6; i++){
                pcThread.consume(i);
            }
        });

        producerThread.start();
        consumerThread.start();
    }

}
