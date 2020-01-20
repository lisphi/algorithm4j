package com.lishaopeng.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastEqualBinarySearchTest {
    private BinarySearch<Integer> bsearch = new LastEqualBinarySearch<>();

    @Test
    void testSearch01() {
        int found = bsearch.search(null, 1);
        assertEquals(-1, found);
    }

    @Test
    void testSearch02() {
        int found = bsearch.search(new Integer[] { 1 }, 1);
        assertEquals(0, found);
    }

    @Test
    void testSearch03() {
        int found = bsearch.search(new Integer[] { 1 }, 2);
        assertEquals(-1, found);
    }

    @Test
    void testSearch04() {
        int found = bsearch.search(new Integer[] { 4, 5 }, 1);
        assertEquals(-1, found);
    }

    @Test
    void testSearch05() {
        int found = bsearch.search(new Integer[] { 4, 5 }, 5);
        assertEquals(1, found);
    }

    @Test
    void testSearch06() {
        int found = bsearch.search(new Integer[] { 4, 5 }, 4);
        assertEquals(0, found);
    }

    @Test
    void testSearch07() {
        int found = bsearch.search(new Integer[] { 4, 4 }, 4);
        assertEquals(1, found);
    }

    @Test
    void testSearch08() {
        int found = bsearch.search(new Integer[] { 4, 5 }, 2);
        assertEquals(-1, found);
    }

    @Test
    void testSearch09() {
        int found = bsearch.search(new Integer[] { 2, 4, 6 }, 1);
        assertEquals(-1, found);
    }

    @Test
    void testSearch10() {
        int found = bsearch.search(new Integer[] { 2, 4, 6 }, 4);
        assertEquals(1, found);
    }

    @Test
    void testSearch11() {
        int found = bsearch.search(new Integer[] { 2, 4, 6 }, 6);
        assertEquals(2, found);
    }

    @Test
    void testSearch12() {
        int found = bsearch.search(new Integer[] { 2, 4, 4 }, 4);
        assertEquals(2, found);
    }

    @Test
    void testSearch13() {
        int found = bsearch.search(new Integer[] { 4, 4, 4 }, 4);
        assertEquals(2, found);
    }

    @Test
    void testSearch14() {
        int found = bsearch.search(new Integer[] { 2, 4, 4, 5 }, 1);
        assertEquals(-1, found);
    }

    @Test
    void testSearch15() {
        int found = bsearch.search(new Integer[] { 2, 4, 4, 5 }, 2);
        assertEquals(0, found);
    }

    @Test
    void testSearch16() {
        int found = bsearch.search(new Integer[] { 2, 4, 4, 5 }, 4);
        assertEquals(2, found);
    }

    @Test
    void testSearch17() {
        int found = bsearch.search(new Integer[] { 2, 4, 4, 4 }, 5);
        assertEquals(-1, found);
    }

    @Test
    void testSearch18() {
        int found = bsearch.search(new Integer[] { 4, 4, 4, 4 }, 4);
        assertEquals(3, found);
    }

    @Test
    void testSearch19() {
        int found = bsearch.search(new Integer[] { 1, 3, 5, 7 }, 3);
        assertEquals(1, found);
    }

    @Test
    void testSearch20() {
        int found = bsearch.search(new Integer[] { 1, 1, 1, 1, 1, 1, 1, 3, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 10, 11, 12 }, 7);
        assertEquals(17, found);
    }
}