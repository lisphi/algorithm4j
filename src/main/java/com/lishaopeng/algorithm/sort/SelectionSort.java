package com.lishaopeng.algorithm.sort;

public class SelectionSort<E extends Comparable<E>> implements SortStrategy<E> {
    @Override
    public E[] sort(E[] items) {
        if (items == null || items.length < 2 ) {
            return items;
        }

        for (int i = 0; i < items.length - 1; i ++) {
            int min = i;
            E item = items[i];
            for (int j = i + 1; j < items.length; j++) {
                if (compare(items[j], items[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                items[i] = items[min];
                items[min] = item;
            }
        }
        return items;
    }
}
