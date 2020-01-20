package com.lishaopeng.algorithm.tree.binary;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class BinaryHeap<E extends Comparable<E>> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] items;
    private int size;
    private boolean bigTopHeap = true;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(boolean bigTopHeap) {
        this(DEFAULT_CAPACITY, bigTopHeap);
    }

    public BinaryHeap(int capacity) {
        this(capacity, true);
    }

    public BinaryHeap(int capacity, boolean bigTopHeap) {
        this.bigTopHeap = bigTopHeap;
        this.items = new Object[capacity + 1];
    }

    public BinaryHeap(E[] items) {
        this(items, true);
    }

    public BinaryHeap(E[] items, boolean bigTopHeap) {
        if (items == null || items.length == 0) {
            this.items = new Object[DEFAULT_CAPACITY + 1];
            return;
        }
        this.items = new Object[Math.max(DEFAULT_CAPACITY, items.length) + 1];
        for (int i = 0; i < items.length; i++) {
            this.items[i + 1] = items[i];
        }
        this.items[0] = null;
        this.size = items.length;
        this.bigTopHeap = bigTopHeap;
        buildHeap(this.size);
    }

    public boolean insert(E item) {
        if (size + 1 >= items.length) {
            ensureCapacity();
        }
        items[++size] = item;
        int top = size;

        while (top / 2 > 0) {
            int nextTop = top /2;
            int winner = compete(nextTop, size);
            if (winner == nextTop) {
                break;
            }
            swap(winner, nextTop);
            top = nextTop;
        }
        return true;
    }

    public E removeTop() {
        if (size <= 0) {
            return null;
        }
        E item = (E)items[1];
        if (size == 1) {
            size--;
            items[1] = null;
            return item;
        }
        items[1] = items[size];
        items[size--] = null;
        heapify(1, size);
        return item;
    }

    public void replaceTop(E item) {
        items[1] = item;
        heapify(1, size);
    }

    public E top() {
        if (size <= 0) {
            return null;
        }
        return (E)items[1];
    }

    public int size() {
        return size;
    }

    public E[] getItems() {
        E[] newItems = (E[])new Comparable[size];
        for (int i = 0; i < newItems.length; i++) {
            newItems[i] = (E)items[i + 1];
        }
        return newItems;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int pos = 1;

            @Override
            public boolean hasNext() {
                return pos <= size();
            }

            @Override
            public E next() {
                return (E)items[pos++];
            }
        };
    }

    private void sort() {
        if (size() <= 1) {
            return;
        }
        int i = size();
        while (i > 1) {
            swap(1, i);
            heapify(1, --i);
        }
    }

    private void heapify(int i, int size) {
        int top = i;
        while (top * 2 <= size || top * 2 + 1 <= size) {
            int winner = compete(top, size);
            if (winner == top) {
                break;
            }
            swap(winner, top);
            top = winner;
        }
    }

    private void swap(int i, int j) {
        E temp = (E)items[j];
        items[j] = items[i];
        items[i] = temp;
    }

    private int compete(int i, int size) {
        if (bigTopHeap) {
            return competeMax(i, size);
        } else {
            return competeMin(i, size);
        }
    }

    private int competeMax(int i, int size) {
        int winner = i;
        if (i * 2 > size) {
            return winner;
        }
        if (i * 2 <= size && compare(items[winner], items[i * 2]) < 0) {
            winner = i * 2;
        }
        if (i * 2 + 1 <= size && compare(items[winner], items[i * 2 + 1]) < 0) {
            winner = i * 2 + 1;
        }
        return winner;
    }

    private int competeMin(int i, int size) {
        int winner = i;
        if (i * 2 > size) {
            return winner;
        }
        if (i * 2 <= size && compare(items[winner], items[i * 2]) > 0) {
            winner = i * 2;
        }
        if (i * 2 + 1 <= size && compare(items[winner], items[i * 2 + 1]) > 0) {
            winner = i * 2 + 1;
        }
        return winner;
    }

    private void ensureCapacity() {
        items = Arrays.copyOf(items, (items.length - 1) * 2 + 1);
    }

    private int compare(Object i, Object j) {
        E item1 = (E)i;
        E item2 = (E)j;
        if (item1 == item2) {
            return 0;
        }
        if (item1 == null) {
            return -1;
        }
        if (j == null) {
            return 1;
        }
        return item1.compareTo(item2);
    }

    private void buildHeap(int size) {
        for (int i = (size - 1) / 2; i >= 1; i--) {
            heapify(i, size);
        }
    }

    public static <E extends Comparable<E>> Iterator<E> sortedIterator(E[] items) {
        return sortedIterator(items, false);
    }

    public static <E extends Comparable<E>> Iterator<E> sortedIterator(E[] items, boolean desc) {
        BinaryHeap<E> heap = new BinaryHeap<>(items, !desc);
        heap.sort();
        return heap.iterator();
    }

    public static <E extends Comparable<E>> E[] sort(E[] items) {
        return sort(items, false);
    }

    public static <E extends Comparable<E>> E[] sort(E[] items, boolean desc) {
        BinaryHeap<E> heap = new BinaryHeap<>(items, !desc);
        heap.sort();
        return heap.getItems();
    }
}