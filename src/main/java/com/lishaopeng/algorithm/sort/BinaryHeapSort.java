package com.lishaopeng.algorithm.sort;

import com.lishaopeng.algorithm.tree.binary.BinaryHeap;

@SuppressWarnings("unchecked")
public class BinaryHeapSort<E extends Comparable<E>> implements SortStrategy<E> {
    @Override
    public E[] sort(E[] items) {
        return BinaryHeap.sort(items);
    }
}
