package com.lishaopeng.algorithm.hash;

public class Node<K1, V1> {
    private K1 key;
    private V1 value;

    K1 getKey() {
        return key;
    }

    V1 getValue() {
        return value;
    }

    void setValue(V1 value) {
        this.value = value;
    }

    Node(K1 key, V1 value) {
        this.key = key;
        this.value = value;
    }
}
