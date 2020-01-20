package com.lishaopeng.algorithm.tree.binary;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


class BinaryHeapTest {

    @Test
    void testConstructor() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        assertEquals(9, heap.size());
        int[] expectedArray = new int[] { 9, 8, 7, 4, 5, 6, 3, 2, 1 };
        Iterator<Integer> iterator = heap.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Integer actual = iterator.next();
            assertEquals(expectedArray[i], actual);
            i++;
        }
    }

    @Test
    void testInsert1() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
        heap.insert(10);
        assertEquals(1, heap.size());
        assertEquals(10, heap.iterator().next());
    }

    @Test
    void testInsert2() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        heap.insert(10);
        assertEquals(10, heap.size());
        assertEquals(10, heap.iterator().next());
    }

    @Test
    void testRemoveTop1() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
        assertNull(heap.removeTop());
    }

    @Test
    void testRemoveTop2() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        assertEquals(9, heap.removeTop());
        assertEquals(8, heap.size());
    }

    @Test
    void testSort1() {
        Iterator<Integer> iterator = BinaryHeap.sortedIterator(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        int[] expectedArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int i = 0;
        while (iterator.hasNext()) {
            Integer actual = iterator.next();
            assertEquals(expectedArray[i], actual);
            i++;
        }
    }

    @Test
    void testSort2() {
        Iterator<Integer> iterator = BinaryHeap.sortedIterator(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, true);
        int[] expectedArray = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int i = 0;
        while (iterator.hasNext()) {
            Integer actual = iterator.next();
            assertEquals(expectedArray[i], actual);
            i++;
        }
    }
}