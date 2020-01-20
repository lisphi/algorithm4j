package com.lishaopeng.algorithm.linear.queue;

import com.lishaopeng.algorithm.tree.binary.BinaryHeap;

public class BinaryHeapPriorityQueue<E extends Comparable<E>> implements CocoaQueue<E> {
    private boolean bigFirst = false;
    private BinaryHeap<E> heap;

    public BinaryHeapPriorityQueue() {
        this.heap = new BinaryHeap<>();
    }

    public BinaryHeapPriorityQueue(boolean bigFirst) {
        this.heap = new BinaryHeap<>(bigFirst);
    }

    @Override
    public boolean offer(E item) {
        return heap.insert(item);
    }

    @Override
    public E poll() {
        return heap.removeTop();
    }

    @Override
    public int size() {
        return heap.size();
    }
}
