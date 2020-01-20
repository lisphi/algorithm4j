package com.lishaopeng.algorithm.hash;

import java.util.Iterator;
import java.util.Objects;

/**
 * SimpleHashMap
 * 采用链表法（Singly Link）解决哈希冲突
 * @param <K>
 * @param <V>
 */
public class SimpleHashMap<K, V> implements CocoaMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private InnerNode<K, V>[] table;
    private int size;
    private Iterable<K> keySet;

    public SimpleHashMap() {
    }

    @SuppressWarnings("unchecked")
    public SimpleHashMap(int capacity) {
        this.table = (InnerNode<K, V>[])new InnerNode[capacity];
    }

    @Override
    public Node<K, V> put(K key, V value) {
        ensureCapacity();
        int index = getIndex(key);
        InnerNode<K, V> node = table[index];
        if (node == null) {
            table[index] = new InnerNode<K, V>(key, value, null);
            ++size;
            return table[index];
        }
        InnerNode<K, V> prev = null;
        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                node.setValue(value);
                return null;
            }
            prev = node;
            node = node.getNext();
        }
        InnerNode<K, V> newNode = new InnerNode<>(key, value, null);
        prev.setNext(newNode);
        ++size;
        return newNode;
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
        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
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
        InnerNode<K, V> prev = null;
        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                if (prev == null) {
                    table[index] = node.getNext();
                } else {
                    prev.setNext(node.getNext());
                    node.setNext(null);
                }
                --size;
                return node.getValue();
            }
            prev = node;
            node = node.getNext();
        }
        return null;
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
        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

//    @Override
//    public Object[] keys() {
//        Object[] objKeys = new Object[size()];
//        if (table == null) {
//            return objKeys;
//        }
//        int i = 0;
//        for (InnerNode<K, V> node : table) {
//            InnerNode<K, V> head = node;
//            while (head != null) {
//                if (i >= objKeys.length) {
//                    return objKeys;
//                }
//                objKeys[i++] = head.getKey();
//                head = head.getNext();
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
                        InnerNode<K, V> currentNode;
                        @Override
                        public boolean hasNext() {
                            if (currentNode != null) {
                                return true;
                            }
                            int i = current;
                            if (i >= table.length) {
                                return false;
                            }
                            while (i < table.length) {
                                InnerNode<K, V> node = table[i];
                                if (node != null) {
                                    return true;
                                }
                                i++;
                            }
                            return false;
                        }

                        @Override
                        public K next() {
                            InnerNode<K, V> node = null;
                            if (current >= table.length) {
                                return null;
                            }
                            if (currentNode == null) {
                                int i = 0;
                                while (i < table.length) {
                                    InnerNode<K, V> n = table[i];
                                    if (n != null) {
                                        current = i;
                                        currentNode = n;
                                        node = n;
                                        break;
                                    }
                                    i++;
                                }
                            } else {
                                node = currentNode;
                            }

                            if (currentNode != null) {
                                if (currentNode.getNext() == null) {
                                    InnerNode<K, V> foundNode = null;
                                    for (int i = current + 1; i < table.length; i++) {
                                        if (table[i] != null) {
                                            current = i;
                                            currentNode = table[i];
                                            foundNode = currentNode;
                                        }
                                    }
                                    if (foundNode == null) {
                                        current = table.length;
                                        currentNode = null;
                                    }
                                } else {
                                    currentNode = currentNode.getNext();
                                }
                            }
                            return node == null ? null : node.getKey();
                        }
                    };
                }
            };
        }
        return keySet;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (table != null && this.size < table.length * DEFAULT_LOAD_FACTOR) {
            return;
        }
        InnerNode<K, V>[] oldTable = table;
        table = (InnerNode<K, V>[])new InnerNode[
                (oldTable == null || oldTable.length == 0)
                ? DEFAULT_INITIAL_CAPACITY
                : oldTable.length * 2];
        if (oldTable == null) {
            return;
        }
        for (int i = 0; i < oldTable.length; i++) {
            InnerNode<K, V> node = oldTable[i];
            if (node == null) {
                continue;
            }
            oldTable[i] = null;
            while (node != null) {
                InnerNode<K, V> currentNode = node;
                int index = getIndex(node.getKey());
                InnerNode<K, V> nodeInNewTable = table[index];
                if (nodeInNewTable == null) {
                    table[index] = currentNode;
                    node = node.getNext();
                    currentNode.setNext(null);
                    continue;
                }

                while (nodeInNewTable != null && nodeInNewTable.getNext() != null) {
                    nodeInNewTable = nodeInNewTable.getNext();
                }
                nodeInNewTable.setNext(currentNode);
                node = node.getNext();
                currentNode.setNext(null);
            }
        }
    }

    private int getIndex(K k) {
        return Objects.hashCode(k) & (table.length - 1);
    }

    public class InnerNode<K1, V1> extends Node<K1, V1> {
        private InnerNode<K1, V1> next;

        InnerNode(K1 key, V1 value) {
            super(key, value);
        }

        InnerNode(K1 key, V1 value, InnerNode<K1, V1> next) {
            super(key, value);
            this.next = next;
        }

        InnerNode<K1, V1> getNext() {
            return this.next;
        }

        void setNext(InnerNode<K1, V1> next) {
            this.next = next;
        }
    }
}
