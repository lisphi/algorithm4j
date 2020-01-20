package com.lishaopeng.algorithm.sort;

public class InsertionSort<E extends Comparable<E>> implements SortStrategy<E> {
    @Override
    public E[] sort(E[] items) {
        if (items == null || items.length < 2 ) {
            return items;
        }

        for (int i = 1; i < items.length; i++) {
            E item = items[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (compare(item, items[j]) < 0) {
                    items[j + 1] = items[j];
                } else {
                    break;
                }
            }
            items[j + 1] = item;
        }
        return items;
    }
}
