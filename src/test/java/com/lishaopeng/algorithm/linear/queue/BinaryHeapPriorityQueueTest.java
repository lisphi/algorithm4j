package com.lishaopeng.algorithm.linear.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryHeapPriorityQueueTest {
    private BinaryHeapPriorityQueue<Integer> pq;

    @BeforeEach
    void setUp() {
        pq = new BinaryHeapPriorityQueue<>();
    }

    @Test
    void test() {
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(2);
        assertEquals(3, pq.poll());
        assertEquals(2, pq.poll());
        assertEquals(2, pq.poll());
        assertEquals(1, pq.poll());
        assertNull(pq.poll());
    }
}