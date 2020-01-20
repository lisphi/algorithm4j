package com.lishaopeng.algorithm.linear.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {
    CocoaQueue<Integer> cocoaQueue;

    @BeforeEach
    void setUp() {
        cocoaQueue = new CircularQueue<>(5);
    }

    @Test
    void enqueue1() {
        assertTrue(cocoaQueue.offer(1));
        assertTrue(cocoaQueue.offer(2));
        assertTrue(cocoaQueue.offer(3));
        assertTrue(cocoaQueue.offer(4));
        assertTrue(cocoaQueue.offer(5));
    }

    @Test
    void enqueue2() {
        assertTrue(cocoaQueue.offer(1));
        assertTrue(cocoaQueue.offer(2));
        assertTrue(cocoaQueue.offer(3));
        assertTrue(cocoaQueue.offer(4));
        assertTrue(cocoaQueue.offer(5));
        assertFalse(cocoaQueue.offer(6));
    }

    @Test
    void dequeue() {
        assertTrue(cocoaQueue.offer(1));
        assertTrue(cocoaQueue.offer(2));
        assertTrue(cocoaQueue.offer(3));
        assertEquals(1, cocoaQueue.poll());
        assertEquals(2, cocoaQueue.poll());
        assertTrue(cocoaQueue.offer(4));
        assertTrue(cocoaQueue.offer(5));
        assertTrue(cocoaQueue.offer(6));
        assertTrue(cocoaQueue.offer(7));
        assertFalse(cocoaQueue.offer(8));
        assertEquals(3, cocoaQueue.poll());
        assertEquals(4, cocoaQueue.poll());
        assertEquals(5, cocoaQueue.poll());

    }
}