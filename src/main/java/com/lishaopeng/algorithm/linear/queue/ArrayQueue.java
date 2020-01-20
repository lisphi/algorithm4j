package com.lishaopeng.algorithm.linear.queue;

import java.util.Arrays;

public class ArrayQueue<E> implements CocoaQueue<E> {
    private Object[] items;
    private int head;
    private int tail;

    public ArrayQueue() {
        this(16);
    }

    public ArrayQueue(int capacity) {
        this.items = new Object[capacity];
    }

    @Override
    public boolean offer(E item) {
        if (tail >= items.length) {
            if (head == 0) {
                ensureCapacity();
            }
            defragment();
        }
        items[tail++] = item;
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
        return item;
    }

    @Override
    public int size() {
        return tail - head;
    }

    private void ensureCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    private void defragment() {
        if (head == 0) {
            return;
        }
        for (int i = 0; i < tail - head; i++) {
            items[i] = items[i + head];
        }
        for (int i = tail - head; i < items.length; i++) {
            items[i] = null;
        }
        tail = tail - head;
        head = 0;
    }
}
