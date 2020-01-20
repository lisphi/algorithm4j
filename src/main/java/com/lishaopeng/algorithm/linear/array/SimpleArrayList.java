package com.lishaopeng.algorithm.linear.array;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<E> implements Iterable<E> {
    private Object[] elements;
    private int size = 0;

    public SimpleArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    public SimpleArrayList() {
        this(10);
    }

    public E add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return element;
    }

    @SuppressWarnings("unchecked")
    public E removeTail() throws Exception {
        if (size <= 0) {
            throw new Exception("no element");
        }
        size--;
        E e = (E)elements[size - 1];
        elements[size - 1] = null;
        return e;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size) {
            return null;
        }
        return (E)elements[index];
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current;
            @Override
            public boolean hasNext() {
                return size > 0 && current < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                return (E)elements[current++];
            }
        };
    }

    private void ensureCapacity(int miniCapacity) {
        if (miniCapacity <= elements.length) {
            return;
        }
        elements = Arrays.copyOf(elements, elements.length * 2);
    }


}
