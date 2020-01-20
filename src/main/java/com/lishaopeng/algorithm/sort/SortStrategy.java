package com.lishaopeng.algorithm.sort;

public interface SortStrategy<E extends Comparable<E>> {
    E[] sort(E[] items);
    
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
