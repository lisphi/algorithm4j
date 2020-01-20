package com.lishaopeng.algorithm.hash;

import java.util.Iterator;
import java.util.Objects;

/**
 * LiteHashMap
 * 采用线性探测法（Linear Probing）解决哈希冲突
 * @param <K>
 * @param <V>
 */
public class LiteHashMap<K, V> implements CocoaMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private InnerNode<K, V>[] table;
    private int size;
    private int threshold;
    private Iterable<K> keySet;

    @SuppressWarnings("unchecked")
    public LiteHashMap() {
        table = (InnerNode<K, V>[])new InnerNode[DEFAULT_INITIAL_CAPACITY];
        setThreshold(table.length);
    }

    @Override
    public Node<K, V> put(K key, V value) {
        ensureCapacity();
        int index = getIndex(key);
        InnerNode<K, V> node = table[index];
        if (node == null) {
            table[index] = new InnerNode<>(key, value);
            ++size;
            return table[index];
        }
        if (Objects.equals(node.getKey(), key)) {
            node.setValue(value);
            return null;
        }
        int nextIndex = findNextIndex(index, key);
        if (nextIndex >= 0) {
            table[nextIndex].setValue(value);
            return null;
        }
        nextIndex = findNextFreeIndex(index, key);
        if (nextIndex >= 0) {
            table[nextIndex] = new InnerNode<>(key, value);
            ++size;
            return table[nextIndex];
        }
        return null;
    }

    @Override
    public V get(K key) {
        if (table == null || table.length == 0) {
            return null;
        }
        int index = getIndex(key);
        InnerNode<K, V> node = table[index];
        if (node == null) {
            return null;
        }
        if (Objects.equals(node.getKey(), key)) {
            return node.getValue();
        }
        int nextIndex = findNextIndex(index, key);
        if (nextIndex < 0) {
            return null;
        }
        return table[nextIndex].getValue();
    }

    @Override
    public V remove(K key) {
        if (table == null || table.length == 0) {
            return null;
        }
        int index = getIndex(key);
        InnerNode<K, V> node = table[index];
        if (node == null) {
            return null;
        }
        if (Objects.equals(node.getKey(), key)) {
            node.setRemoved(true);
            --size;
            return node.getValue();
        }
        int nextIndex = findNextIndex(index, key);
        if (nextIndex < 0) {
            return null;
        }
        table[nextIndex].setRemoved(true);
        --size;
        return table[nextIndex].getValue();
    }

    @Override
    public boolean containsKey(K key) {
        if (table == null || table.length == 0) {
            return false;
        }
        int index = getIndex(key);
        InnerNode<K, V> node = table[index];
        if (node == null) {
            return false;
        }
        if (Objects.equals(node.getKey(), key)) {
            return true;
        }
        return findNextIndex(index, key) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

//    @Override
//    public Object[] keys() {
//        Object[] objKeys = new Object[size()];
//        int i = 0;
//        for (InnerNode<K, V> node : table) {
//            if (node != null && !node.isRemoved()) {
//                objKeys[i++] = node.getKey();
//            }
//        }
//        return objKeys;
//    }

    public Iterable<K> keySet() {
        if (keySet == null) {
            keySet = new Iterable<K>() {
                @Override
                public Iterator<K> iterator() {
                    return new Iterator<K>() {
                        int current;
                        @Override
                        public boolean hasNext() {
                            if (current >= table.length) {
                                return false;
                            }
                            int i = current;
                            while (i < table.length) {
                                if (table[i] != null && !table[i].isRemoved()) {
                                    return true;
                                }
                                i++;
                            }
                            return false;
                        }

                        @Override
                        public K next() {
                            if (current >= table.length) {
                                return null;
                            }
                            while (current < table.length) {
                                if (table[current] != null && !table[current].isRemoved()) {
                                    break;
                                }
                                current++;
                            }
                            if (current < table.length) {
                                return table[current].getKey();
                            }
                            return null;
                        }
                    };
                }
            };
        }
        return keySet;
    }
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size < threshold) {
            return;
        }
        InnerNode<K, V>[] oldTable = table;
        table = (InnerNode<K, V>[])new InnerNode[oldTable.length * 2];
        setThreshold(table.length);
        for (int i = 0; i < oldTable.length; i++) {
            InnerNode<K, V> node = oldTable[i];
            if (node == null) {
                continue;
            }
            if (node.isRemoved()) {
                oldTable[i] = null;
                continue;
            }
            oldTable[i] = null;
            int index = getIndex(node.getKey());
            InnerNode<K, V> nodeInNewTable = table[index];
            if (nodeInNewTable == null) {
                table[index] = node;
                continue;
            }
            int nextIndex = findNextFreeIndex(index, node.getKey());
            if (nextIndex >= 0) {
                table[nextIndex] = node;
            }
        }
    }

    private int findNextIndex(int index, K key) {
        for (int j = index + 1; j < table.length; j++) {
            if (table[j] == null) {
                return -1;
            }
            if (!table[j].isRemoved() && Objects.equals(table[j].getKey(), key)) {
                return j;
            }
        }
        for (int j = 0; j < index; j++) {
            if (table[j] == null) {
                return -1;
            }
            if (!table[j].isRemoved() && Objects.equals(table[j].getKey(), key)) {
                return j;
            }
        }
        return -1;
    }

    private int findNextFreeIndex(int index, K key) {
        for (int j = index + 1; j < table.length; j++) {
            if (table[j] == null || table[j].isRemoved()) {
                return j;
            }
        }
        for (int j = 0; j < index; j++) {
            if (table[j] == null || table[j].isRemoved()) {
                return j;
            }
        }
        return -1;
    }

    private int getIndex(K k) {
        return Objects.hashCode(k) & (table.length - 1);
    }

    private void setThreshold(int len) {
        threshold = len * 2 / 3;
    }

    class InnerNode<K1, V1> extends Node<K1, V1> {
        private boolean removed;
        public boolean isRemoved() {
            return removed;
        }

        public void setRemoved(boolean removed) {
            this.removed = removed;
        }

        InnerNode(K1 key, V1 value) {
            super(key, value);
        }
    }
}
