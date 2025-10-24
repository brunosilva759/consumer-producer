package io.codeforall.bootcamp.bqueue;

import java.util.LinkedList;
import java.util.Queue;


public class BQueue<Pizza> {

    private final Queue<Pizza> queue;
    private final int limit;


    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(Pizza data) {

        while (queue.size() == limit) {
            try {
                System.out.println("queue is currently full.");
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        queue.add(data);
        System.out.println("pizza added current amount in queue: " + queue.size());
        notifyAll();
    }


    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized Pizza poll() {

        while (queue.isEmpty()) {
            try {
                System.out.println("there is no pizza left, you have to wait");
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }

        }
        Pizza q = queue.poll();
        notifyAll();
        return q;
    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {
        return queue.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;
    }
}

