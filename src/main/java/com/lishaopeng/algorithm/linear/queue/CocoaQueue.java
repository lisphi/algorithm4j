package com.lishaopeng.algorithm.linear.queue;

public interface CocoaQueue<E> {
    boolean offer(E item);
    E poll();
    int size();
}
