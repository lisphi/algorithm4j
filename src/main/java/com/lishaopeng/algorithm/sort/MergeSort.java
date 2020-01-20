package com.lishaopeng.algorithm.sort;

public class MergeSort<E extends Comparable<E>> implements SortStrategy<E>  {
    @Override
    public E[] sort(E[] items) {
        if (items == null || items.length < 2 ) {
            return items;
        }
        sort(items, 0, items.length - 1);
        return items;
    }

    private void sort(E[] items, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(items, start, mid);
        sort(items, mid + 1, end);
        merge(items, start, mid, end);
    }

    @SuppressWarnings("unchecked")
    private void merge(E[] items, int start, int mid, int end) {
        Object[] mergedItems = new Object[end - start + 1];
        int i = 0;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (compare(items[left], items[right]) <= 0) {
                mergedItems[i++] = items[left++];
            } else {
                mergedItems[i++] = items[right++];
            }
        }
        while (left <= mid) {
            mergedItems[i++] = items[left++];
        }
        while (right <= end) {
            mergedItems[i++] = items[right++];
        }
        for (int j = 0; j <= end - start; j++) {
            items[j + start] = (E)mergedItems[j];
        }
    }
}
