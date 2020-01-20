package com.lishaopeng.algorithm.median;

public interface Median<E extends Comparable<E>> {
    E getValue(E[] items);

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
