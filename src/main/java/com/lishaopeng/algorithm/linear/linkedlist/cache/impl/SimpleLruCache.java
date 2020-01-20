package com.lishaopeng.algorithm.linear.linkedlist.cache.impl;

import com.lishaopeng.algorithm.linear.linkedlist.SinglyLinkedNode;
import com.lishaopeng.algorithm.linear.linkedlist.cache.Cache;

import java.util.Objects;

public class SimpleLruCache implements Cache {
    private int maxSize;
    private int size;
    private SinglyLinkedNode<KeyValue> head;

    public SimpleLruCache(int maxSize) {
        this.maxSize = maxSize;
        this.head = null;
    }

    public String get(String key) {
        SinglyLinkedNode<KeyValue> node = getNode(key);
        if (node == null || node.getData() == null) {
            return null;
        }
        return node.getData().getValue();
    }

    public void put(String key, String value) {
        if (head == null) {
            head = SinglyLinkedNode.of(KeyValue.of(key, value), null);
            size++;
            return;
        }

        SinglyLinkedNode<KeyValue> current = head;
        SinglyLinkedNode<KeyValue> foundNode = null;
        SinglyLinkedNode<KeyValue> prevNode = null;
        do {
            if (Objects.equals(key, current.getData().getKey())) {
                foundNode = current;
                break;
            }
            SinglyLinkedNode<KeyValue> nextNode = current.getNext();
            prevNode = current;
            current = nextNode;
        } while (current != null && current.getNext() != null);

        if (foundNode == null) {
            if (size >= maxSize) {
                removeLast(prevNode);
            } else {
                size++;
            }
            insertFirst(SinglyLinkedNode.of(KeyValue.of(key, value), null));
        } else {
            foundNode.getData().setValue(value);
            if (prevNode != null) {
                removeCurrent(prevNode);
                insertFirst(foundNode);
            }
        }
    }

    @Override
    public void remove(String key) {
        if (head == null) {
            return;
        }
        SinglyLinkedNode<KeyValue> current = head;
        SinglyLinkedNode<KeyValue> prev = null;
        SinglyLinkedNode<KeyValue> found = null;
        while (current != null) {
            if (Objects.equals(key, current.getData().getKey())) {
                found = current;
                break;
            }
            prev = current;
            current = current.getNext();
        }
        if (found == null) {
            return;
        }
        if (prev == null) {
            head = null;
        } else {
            prev.setNext(found.getNext());
            found.setNext(null);
        }
        --size;
    }

    @Override
    public int size() {
        return this.size;
    }

    private SinglyLinkedNode<KeyValue> getNode(String key) {
        if (head == null) {
            return null;
        }
        SinglyLinkedNode<KeyValue> current = head;
        while (current != null) {
            if (Objects.equals(key, current.getData().getKey())) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    private void removeLast(SinglyLinkedNode<KeyValue> prevNodeForTail) {
        if (prevNodeForTail != null) {
            prevNodeForTail.setNext(null);
        }
    }

    private void insertFirst(SinglyLinkedNode<KeyValue> newHead) {
        newHead.setNext(head);
        head = newHead;
    }

    private void removeCurrent(SinglyLinkedNode<KeyValue> prevNode) {
        SinglyLinkedNode<KeyValue> currentNode = prevNode.getNext();
        if (currentNode != null) {
            prevNode.setNext(currentNode.getNext());
        }
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getSize() {
        return this.size;
    }

    public SinglyLinkedNode<KeyValue> getHead() {
        return head;
    }
}
