package com.iview.threads.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        (new Thread(producer)).start();
        (new Thread(consumer)).start();
    }

}

class Producer implements Runnable {
    private BlockingQueue<String> queue;

    List<String> messages = Arrays.asList(
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "Wouldn't you eat ivy too?");

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (String message : messages) {
                queue.put(message);
                Thread.sleep(2000);
            }
            queue.put("DONE");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            try {
                String msg = null;
                while (!((msg = queue.take()).equals("DONE")))
                    System.out.println(msg);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}