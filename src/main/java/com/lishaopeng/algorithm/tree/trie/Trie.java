package com.lishaopeng.algorithm.tree.trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(Character.MIN_VALUE);
    }

    public void insert(String text) {
        if (text == null || text == "") {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = indexOf(c);
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(c);
            }
            node = node.children[index];
        }
        node.isEndingChar = true;
    }

    public boolean find(String pre) {
        if (pre == null || pre == "") {
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < pre.length(); i++) {
            char c = pre.charAt(i);
            int index = indexOf(c);
            if (node.children[index] == null) {
                break;
            }
            node = node.children[index];
        }
        return node.isEndingChar;
    }

    private int indexOf(char c) {
        int num = Character.getNumericValue(c);
        if (num >= 65 && num <= 90) {
            return num - 65;
        }
        if (num >= 97 && num <= 122) {
            return num - 97;
        }
        return 26;
    }

    class TrieNode {
        private char data;
        private TrieNode[] children;
        private boolean isEndingChar;
        public TrieNode(char data) {
            this.data = data;
            this.children = new TrieNode[27];
        }
    }
}
