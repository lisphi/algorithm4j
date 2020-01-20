package com.lishaopeng.algorithm.sort;

public class BubbleSort<E extends Comparable<E>> implements SortStrategy<E> {
    @Override
    public E[] sort(E[] items) {
        if (items == null || items.length < 2 ) {
            return items;
        }

        for (int i = 0; i < items.length; i++) {
            boolean swap = false;
            for (int j = 0; j < items.length - 1 - i; j++) {
                if (compare(items[j], items[j + 1]) > 0) {
                    E temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return items;
    }
}
