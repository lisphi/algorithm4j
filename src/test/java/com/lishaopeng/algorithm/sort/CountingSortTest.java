package com.lishaopeng.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {
    SortStrategy<Value> sorting = new CountingSort();

    @Test
    void testSort() {
        Value[] values = sorting.sort(CountingSort.sampleValues);
        assertEquals(1, values[0].getValue());
        assertEquals(5, values[CountingSort.sampleValues.length - 1].getValue());
    }
}