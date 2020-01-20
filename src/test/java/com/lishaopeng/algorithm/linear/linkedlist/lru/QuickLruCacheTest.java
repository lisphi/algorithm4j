package com.lishaopeng.algorithm.linear.linkedlist.lru;

import com.lishaopeng.algorithm.linear.linkedlist.cache.Cache;
import com.lishaopeng.algorithm.linear.linkedlist.cache.impl.QuickLruCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickLruCacheTest {
    Cache cache;

    @BeforeEach
    void setUp() {
        cache = new QuickLruCache(5);
    }

    @Test
    void testPushOneNode() {
        cache.put("a", "1");
        assertEquals(1, cache.size());
    }

    @Test
    void testPushThreeNodes() {
        cache.put("a", "1");
        cache.put("b", "2");
        cache.put("c", "3");
        assertEquals(3, cache.size());
    }

    @Test
    void testPushSixNodes() {
        cache.put("a", "1");
        cache.put("b", "2");
        cache.put("c", "3");
        cache.put("d", "4");
        cache.put("e", "5");
        cache.put("f", "6");
        assertEquals(5, cache.size());
    }

    @Test
    void testGet1() {
        assertNull(cache.get("a"));
    }

    @Test
    void testGet2() {
        cache.put("a", "1");
        assertEquals("1", cache.get("a"));
        assertNull(cache.get("b"));
    }

    @Test
    void testGet3() {
        cache.put("a", "1");
        cache.put("b", "2");
        cache.put("c", "3");
        assertEquals("1", cache.get("a"));
        assertEquals("2", cache.get("b"));
        assertEquals("3", cache.get("c"));
        assertNull(cache.get("d"));
    }

    @Test
    void testGet4() {
        cache.put("a", "1");
        cache.put("b", "2");
        cache.put("c", "3");
        cache.put("d", "4");
        cache.put("e", "5");
        cache.put("f", "6");
        assertNull(cache.get("a"));
        assertEquals("2", cache.get("b"));
        assertEquals("3", cache.get("c"));
        assertEquals("4", cache.get("d"));
        assertEquals("5", cache.get("e"));
        assertEquals("6", cache.get("f"));
    }

    @Test
    void testRemove1() {
        cache.remove("a");
        assertEquals(0, cache.size());
    }

    @Test
    void testRemove2() {
        cache.put("a", "1");
        cache.remove("aa");
        cache.remove("a");
        assertEquals(0, cache.size());
        assertNull(cache.get("a"));
    }

    @Test
    void testRemove3() {
        cache.put("a", "1");
        cache.put("b", "2");
        cache.put("c", "3");
        cache.remove("aa");
        cache.remove("a");
        assertEquals(2, cache.size());
        assertNull(cache.get("a"));
    }

    @Test
    void testRemove4() {
        cache.put("a", "1");
        cache.put("b", "2");
        cache.put("c", "3");
        cache.put("d", "4");
        cache.put("e", "5");
        cache.put("f", "6");
        cache.remove("a");
        assertEquals(5, cache.size());
        cache.remove("f");
        assertNull(cache.get("f"));
    }
}