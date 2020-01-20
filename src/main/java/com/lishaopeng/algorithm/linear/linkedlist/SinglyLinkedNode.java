package com.lishaopeng.algorithm.linear.linkedlist;

public class SinglyLinkedNode<T> {
    private T data;
    private SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T data, SinglyLinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SinglyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode<T> next) {
        this.next = next;
    }

    public SinglyLinkedNode<T> append(SinglyLinkedNode<T> node) {
        this.setNext(node);
        return node;
    }

    public static <T> SinglyLinkedNode<T> of(T data, SinglyLinkedNode<T> next) {
        return new SinglyLinkedNode<>(data, next);
    }

    public static <T> SinglyLinkedNode<T> of(T data) {
        return new SinglyLinkedNode<>(data, null);
    }
}
