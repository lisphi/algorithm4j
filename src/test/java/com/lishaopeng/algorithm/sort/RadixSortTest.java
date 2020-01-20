package com.lishaopeng.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    SortStrategy<Value> sorting = new RadixSort();

    @Test
    void testSort() {
        Value[] values = sorting.sort(RadixSort.sampleValues);
        assertEquals("112", values[0].getName());
        assertEquals("934", values[9].getName());
    }
}