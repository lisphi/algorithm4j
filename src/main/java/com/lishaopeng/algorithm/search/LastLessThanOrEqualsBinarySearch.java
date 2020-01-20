package com.lishaopeng.algorithm.search;

public class LastLessThanOrEqualsBinarySearch<E extends Comparable<E>> implements BinarySearch<E> {
    @Override
    public int search(E[] items, E item) {
        if (items == null || items.length == 0) {
            return -1;
        }
        return searchV1(items, item);
    }

    private int searchV1(E[] items, E item) {
        int low = 0;
        int height = items.length - 1;
        while (low <= height) {
            int mid = (low + height) / 2;
            if (compare(items[mid], item) > 0){
                height = mid - 1;
            } else {
                if (mid == height || compare(items[mid + 1], item) > 0 ) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }
}
