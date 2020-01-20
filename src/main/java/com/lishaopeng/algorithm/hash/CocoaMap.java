package com.lishaopeng.algorithm.hash;

public interface CocoaMap<K, V> {
    Node<K, V> put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean containsKey(K key);
    int size();
    Iterable<K> keySet();
}
