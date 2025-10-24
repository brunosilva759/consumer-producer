package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bqueue.BQueue;
import io.codeforall.bootcamp.bqueue.Pizza;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue<Pizza> queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        try {

            for (int i = 0; i < elementNum; i++) {
                Pizza pizza = new Pizza();
                queue.offer(pizza);
                System.out.println("produced new pizza " + Thread.currentThread().getName());

//                if (queue.getSize() == 0) {
//                    System.out.println("Producer filled the queue");
//                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}