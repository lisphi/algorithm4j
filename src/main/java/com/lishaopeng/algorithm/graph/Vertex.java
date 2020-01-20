package com.lishaopeng.algorithm.graph;

import com.lishaopeng.algorithm.linear.linkedlist.SinglyLinkedNode;

import java.util.Objects;

public class Vertex<E> {
    private E value;
    private SinglyLinkedNode<Vertex<E>> adjacencyLink;

    public void setValue(E value) {
        this.value = value;
    }

    public void setAdjacencyLink(SinglyLinkedNode<Vertex<E>> adjacencyLink) {
        this.adjacencyLink = adjacencyLink;
    }

    public E getValue() {
        return value;
    }

    public SinglyLinkedNode<Vertex<E>> getAdjacencyLink() {
        return adjacencyLink;
    }

    @Override
    public int hashCode() {
        return value == null ? 0 : 0x2b338569 & value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Vertex) {
            return Objects.equals(value, ((Vertex)obj).value);
        }
        return false;
    }
}
