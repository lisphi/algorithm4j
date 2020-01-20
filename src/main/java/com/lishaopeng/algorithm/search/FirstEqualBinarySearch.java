package com.lishaopeng.algorithm.search;

public class FirstEqualBinarySearch<E extends Comparable<E>> implements BinarySearch<E> {
    @Override
    public int search(E[] items, E item) {
        if (items == null || items.length == 0) {
            return -1;
        }
        return searchV3(items, item);
    }

    private int searchV1(E[] items, E item) {
        int low = 0;
        int height = items.length - 1;

        int mid = (low + height) / 2;
        while (mid > low && mid < height) {
            if (compare(items[mid], item) > 0) {
                height = mid - 1;
            } else if (compare(items[mid], item) < 0){
                low = mid + 1;
            } else {
                height = mid;
            }
            mid = (low + height) / 2;
        }
        if (compare(items[mid], item) == 0) {
            return mid;
        }
        if (mid + 1 < items.length && compare(items[mid + 1], item) == 0) {
            return mid + 1;
        }
        return -1;
    }

    private int searchV2(E[] items, E item) {
        int low = 0;
        int height = items.length - 1;
        while (low < height) {
            int mid = (low + height) / 2;
            if (compare(items[mid], item) > 0) {
                height = mid - 1;
            } else if (compare(items[mid], item) < 0){
                low = mid + 1;
            } else {
                height = mid;
            }
        }
        if (compare(items[low], item) == 0) {
            return low;
        }
        return -1;
    }

    private int searchV3(E[] items, E item) {
        int low = 0;
        int height = items.length - 1;
        while (low <= height) {
            int mid = (low + height) / 2;
            if (compare(items[mid], item) > 0) {
                height = mid - 1;
            } else if (compare(items[mid], item) < 0){
                low = mid + 1;
            } else {
                if (mid == low || compare(items[mid - 1], item) != 0) {
                    return mid;
                }
                height = mid - 1;
            }
        }
        return -1;
    }
}
