package com.lishaopeng.algorithm.median;

import com.lishaopeng.algorithm.tree.binary.BinaryHeap;

@SuppressWarnings("unchecked")
public class HeapMedian<E extends Comparable<E>> implements Median<E> {
    @Override
    public E getValue(E[] items) {
        if (items == null) {
            return null;
        }
        if (items.length == 1) {
            return items[0];
        }
        int bigCapacity = items.length / 2 + items.length % 2;
        BinaryHeap<E> bigHeap = new BinaryHeap<E>(bigCapacity, true);
        for (int i = 0; i < bigCapacity; i++) {
            bigHeap.insert(items[i]);
        }
        for (int i = bigCapacity; i < items.length; i++) {
            E current = items[i];
            if (compare(current, bigHeap.top()) < 0) {
                bigHeap.replaceTop(current);
            }
        }
        return bigHeap.top();
    }
}
