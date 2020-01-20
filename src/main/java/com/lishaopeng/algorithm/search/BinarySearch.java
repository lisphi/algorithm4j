package com.lishaopeng.algorithm.search;

public interface BinarySearch<E extends Comparable<E>> {
    int search(E[] items, E item);

    default int compare(E i, E j) {
        if (i == j) {
            return 0;
        }
        if (i == null) {
            return -1;
        }
        if (j == null) {
            return 1;
        }
        return i.compareTo(j);
    }
}
