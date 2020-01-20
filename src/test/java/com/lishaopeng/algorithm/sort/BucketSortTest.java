package com.lishaopeng.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {
    SortStrategy<Value> sorting = new BucketSort();

    @Test
    void testSort() {
        Value[] values = sorting.sort(BucketSort.sampleValues);
        assertEquals(1, values[0].getValue());
        assertEquals(5, values[BucketSort.sampleValues.length - 1].getValue());
    }
}