package com.lishaopeng.algorithm.tree.trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void find() {
        Trie trie = new Trie();
        trie.insert("cocoa");
        trie.insert("coconut");
        trie.insert("coconut oil");
        trie.insert("coconut crab");
        trie.insert("你好");
        assertEquals(false, trie.find("coco"));
        assertEquals(true, trie.find("cocoa"));
        assertEquals(false, trie.find("coconut "));
        assertEquals(true, trie.find("coconut crab"));
    }
}