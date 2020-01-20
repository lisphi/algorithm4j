package com.lishaopeng.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    SortStrategy<Value> sorting = new MergeSort<>();

    @Test
    void testSort1() {
        Value[] sortedArray = sorting.sort(new Value[]{
                Value.of(1, "a"),
                Value.of(2, "b")
        });
        assertEquals(1, sortedArray[0].getValue());
        assertEquals(2, sortedArray[1].getValue());
    }

    @Test
    void testSort2() {
        Value[] sortedArray = sorting.sort(new Value[]{
                Value.of(2, "b"),
                Value.of(1, "a")
        });
        assertEquals(1, sortedArray[0].getValue());
        assertEquals(2, sortedArray[1].getValue());
    }

    @Test
    void testSort3() {
        Value[] sortedArray = sorting.sort(new Value[]{
                Value.of(3, "c"),
                Value.of(8, "h"),
                Value.of(5, "e"),
                Value.of(6, "f"),
                Value.of(7, "g"),
                Value.of(0, "0"),
                Value.of(3, "cc"),
                Value.of(4, "d"),
                Value.of(9, "i"),
                Value.of(2, "b"),
        });
        assertEquals(0, sortedArray[0].getValue());
        assertEquals(2, sortedArray[1].getValue());
        assertEquals(3, sortedArray[2].getValue());
        assertEquals("c", sortedArray[2].getName());
        assertEquals(3, sortedArray[3].getValue());
        assertEquals("cc", sortedArray[3].getName());
        assertEquals(4, sortedArray[4].getValue());
        assertEquals(5, sortedArray[5].getValue());
        assertEquals(6, sortedArray[6].getValue());
        assertEquals(7, sortedArray[7].getValue());
        assertEquals(8, sortedArray[8].getValue());
        assertEquals(9, sortedArray[9].getValue());
    }
}