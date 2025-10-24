package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bqueue.BQueue;
import io.codeforall.bootcamp.bqueue.Pizza;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue<Pizza> queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        try {
            synchronized (queue) {
                for (int i = 0; i < elementNum; i++) {
                    System.out.println("consumer attempts to take pizza " + Thread.currentThread().getName());
                    queue.poll();
                }
                if (queue.getSize() == 0) {
                    System.out.println("consumer emptied the queue");
                }

            }


        } catch (Exception e) {
            e.getMessage();
        }
    }

}