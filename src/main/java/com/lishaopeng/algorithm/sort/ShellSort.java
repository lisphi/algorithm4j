package com.lishaopeng.algorithm.sort;

public class ShellSort<E extends Comparable<E>> implements SortStrategy<E> {
    @Override
    public E[] sort(E[] items) {
        if (items == null || items.length < 2 ) {
            return items;
        }
        for (int step = items.length / 2; step >= 1; step = step / 2) {
            for (int i = 0; i < step; i++) {
                insertionSort(items, i, step);
            }
        }
        return items;
    }

    private void insertionSort(E[] items, int start, int step) {
        for (int i = start + step; i < items.length; i += step) {
            E item = items[i];
            int j = i - step;
            for (; j >= 0; j -= step) {
                if (compare(item, items[j]) < 0) {
                    items[j + step] = items[j];
                } else {
                    break;
                }
            }
            items[j + step] = item;
        }
    }
}
