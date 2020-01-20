package com.lishaopeng.algorithm.linear.linkedlist.cache;

public interface Cache {
    String get(String key);
    void put(String key, String value);
    void remove(String key);
    int size();
}
