package com.lishaopeng.algorithm.linear.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> {
    private Object[] elements;
    private int size;

    public ArrayStack(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public ArrayStack() {
        this(10);
    }

    public E push(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        size--;
        Object e = elements[size];
        elements[size] = null;
        return (E)e;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity(int miniCapacity) {
        if (miniCapacity <= elements.length) {
            return;
        }
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
