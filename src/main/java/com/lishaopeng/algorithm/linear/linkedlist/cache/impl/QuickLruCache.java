package com.lishaopeng.algorithm.linear.linkedlist.cache.impl;

import com.lishaopeng.algorithm.hash.CocoaMap;
import com.lishaopeng.algorithm.hash.SimpleHashMap;
import com.lishaopeng.algorithm.linear.linkedlist.DoublyLinkedNode;
import com.lishaopeng.algorithm.linear.linkedlist.cache.Cache;

public class QuickLruCache implements Cache {
    private int maxSize;
    private DoublyLinkedNode<KeyValue> head;
    private DoublyLinkedNode<KeyValue> tail;
    private CocoaMap<String, DoublyLinkedNode<KeyValue>> nodeMap;

    public QuickLruCache(int maxSize) {
        this.maxSize = maxSize;
        this.head = null;
        this.tail = head;
        this.nodeMap = new SimpleHashMap<>();
    }

    @Override
    public String get(String key) {
        DoublyLinkedNode<KeyValue> node = this.nodeMap.get(key);
        if (node == null || node.getData() == null) {
            return null;
        }
        return node.getData().getValue();
    }

    @Override
    public void put(String key, String value) {
        if (head == null) {
            head = DoublyLinkedNode.of(KeyValue.of(key, value), null, null);
            tail = head;
            nodeMap.put(key, head);
            return;
        }
        DoublyLinkedNode<KeyValue> foundNode = nodeMap.get(key);
        if (foundNode == null) {
            if (nodeMap.size() >= maxSize) {
                removeLastAndSyncMap();
            }
            insertFirstAndSyncMap(DoublyLinkedNode.of(KeyValue.of(key, value), null, null));
        } else {
            foundNode.getData().setValue(value);
            if (foundNode.getPrev() != null || foundNode.getNext() != null) {
                removeCurrent(foundNode);
                insertFirst(foundNode);
            }
        }
    }

    @Override
    public void remove(String key) {
        DoublyLinkedNode<KeyValue> node = this.nodeMap.get(key);
        if (node == null) {
            return;
        }
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        }
        node.setNext(null);
        this.nodeMap.remove(key);
    }

    @Override
    public int size() {
        return this.nodeMap.size();
    }

    private void removeLastAndSyncMap() {
        if (tail != null) {
            DoublyLinkedNode<KeyValue> prevNode = tail.getPrev();
            prevNode.setNext(null);
            tail.setPrev(null);
            nodeMap.remove(tail.getData().getKey());
            this.tail = prevNode;
        }
    }

    private void insertFirst(DoublyLinkedNode<KeyValue> newHead) {
        newHead.setNext(head);
        head.setPrev(newHead);
        head = newHead;
    }

    private void insertFirstAndSyncMap(DoublyLinkedNode<KeyValue> newHead) {
        insertFirst(newHead);
        nodeMap.put(newHead.getData().getKey(), newHead);
    }

    private void removeCurrent(DoublyLinkedNode<KeyValue> currentNode) {
        DoublyLinkedNode<KeyValue> prevNode = currentNode.getPrev();
        if (prevNode != null) {
            prevNode.setNext(currentNode.getNext());
        }
        currentNode.setPrev(null);
        currentNode.setNext(null);
    }
}
