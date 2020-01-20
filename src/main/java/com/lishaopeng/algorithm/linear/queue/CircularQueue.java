package com.lishaopeng.algorithm.linear.queue;

public class CircularQueue<E> implements CocoaQueue<E> {
    private int capacity;
    private Object[] items;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        this.capacity = capacity + 1;
        this.items = new Object[this.capacity];
    }

    public CircularQueue() {
        this(10);
    }

    @Override
    public boolean offer(E item) {
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E poll() {
        if (head == tail) {
            return null;
        }
        E item = (E)items[head];
        items[head] = null;
        head++;
        if (head >= capacity) {
            head = head % capacity;
        }
        return item;
    }

    @Override
    public int size() {
        int size = tail - head;
        if (size < 0) {
            size += this.capacity;
        }
        return size;
    }

}
