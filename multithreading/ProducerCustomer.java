package multithreading;

import java.util.ArrayList;
import java.util.List;

class Producer extends Thread {
    private List<Integer> buffer;
    private int maxSize;

    public Producer(List<Integer> buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            produce(i);
        }
    }

    private void produce(int item) {
        synchronized (buffer) {
            while (buffer.size() == maxSize) {
                try {
                    System.out.println("Buffer is full. Producer waits...");
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            buffer.add(item);
            System.out.println("Produced: " + item);
            buffer.notifyAll();
        }
    }
}

class Consumer extends Thread {
    private List<Integer> buffer;

    public Consumer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    private void consume() {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                try {
                    System.out.println("Buffer is empty. Consumer waits...");
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int item = buffer.remove(0);
            System.out.println("Consumed: " + item);
            buffer.notifyAll();
        }
    }
}

public class ProducerCustomer{
    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>();
        int maxSize = 5;

        Producer producer = new Producer(buffer, maxSize);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}