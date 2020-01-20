package com.lishaopeng.algorithm.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {
    CocoaMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new SimpleHashMap<>();
    }

    @Test
    void put() {
        map.put("Mary had a little lamb", "a");
        map.put("Little lamb, little lamb,", "b");
        assertEquals(2, map.size());
        map.put("Mary had a little lamb", "aa");
        assertEquals(2, map.size());
        map.put("Whose fleece was white as snow.", "c");
        map.put("And everywhere that Mary went,", "d");
        map.put("Mary went, Mary went,", "e");
        map.put("Everywhere that Mary went", "f");
        map.put("The lamb was sure to go.", "g");
        map.put("He followed her to school one day,", "h");
        map.put("School one day, school one day,", "i");
        map.put("He followed her to school one day", "j");
        map.put("Which was against the rules.", "k");
        map.put("It made the children laugh and play,", "l");
        map.put("Laugh and play, laugh and play,", "m");
        map.put("It made the children laugh and play,", "ll");
        map.put("To see a lamb at school.", "n");
        map.put("And so the teacher turned it out,", "o");
        assertEquals(15, map.size());
    }

    @Test
    void get() {
        map.put("Mary had a little lamb", "a");
        map.put("Little lamb, little lamb,", "b");
        assertEquals("a", map.get("Mary had a little lamb"));
        map.put("Mary had a little lamb", "aa");
        assertEquals("aa", map.get("Mary had a little lamb"));
        map.put("Whose fleece was white as snow.", "c");
        map.put("And everywhere that Mary went,", "d");
        map.put("Mary went, Mary went,", "e");
        map.put("Everywhere that Mary went", "f");
        map.put("The lamb was sure to go.", "g");
        map.put("He followed her to school one day,", "h");
        map.put("School one day, school one day,", "i");
        map.put("He followed her to school one day", "j");
        map.put("Which was against the rules.", "k");
        map.put("It made the children laugh and play,", "l");
        map.put("Laugh and play, laugh and play,", "m");
        map.put("It made the children laugh and play,", "ll");
        map.put("To see a lamb at school.", "o");
        map.put("And so the teacher turned it out,", "p");
        assertEquals("ll", map.get("It made the children laugh and play,"));
    }

    @Test
    void remove() {
        map.put("Mary had a little lamb", "a");
        map.put("Little lamb, little lamb,", "b");
        map.put("Mary had a little lamb", "aa");
        map.put("Whose fleece was white as snow.", "c");
        map.put("And everywhere that Mary went,", "d");
        map.put("Mary went, Mary went,", "e");
        map.put("Everywhere that Mary went", "f");
        map.put("The lamb was sure to go.", "g");
        map.put("He followed her to school one day,", "h");
        map.put("School one day, school one day,", "i");
        map.put("He followed her to school one day", "j");
        map.put("Which was against the rules.", "k");
        map.put("It made the children laugh and play,", "l");
        map.put("Laugh and play, laugh and play,", "m");
        map.put("It made the children laugh and play,", "n");
        map.put("To see a lamb at school.", "o");
        map.put("And so the teacher turned it out,", "p");
        assertEquals(15, map.size());
        assertEquals("k", map.remove("Which was against the rules."));
        assertEquals(14, map.size());
    }
}