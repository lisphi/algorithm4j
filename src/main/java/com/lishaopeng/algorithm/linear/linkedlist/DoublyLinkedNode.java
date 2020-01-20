package com.lishaopeng.algorithm.linear.linkedlist;

public class DoublyLinkedNode<T> {
    private T data;
    private DoublyLinkedNode<T> prev;
    private DoublyLinkedNode<T> next;

    public DoublyLinkedNode(T data, DoublyLinkedNode<T> prev, DoublyLinkedNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public static <T> DoublyLinkedNode<T> of(T data, DoublyLinkedNode<T> prev, DoublyLinkedNode<T> next) {
        return new DoublyLinkedNode<>(data, prev, next);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedNode<T> prev) {
        this.prev = prev;
    }

    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }
}
