package com.lishaopeng.algorithm.graph;

import com.lishaopeng.algorithm.hash.SimpleHashMap;
import com.lishaopeng.algorithm.linear.linkedlist.SinglyLinkedNode;


public class Graph<E> {
    private static Object object = new Object();
    private SimpleHashMap<Vertex<E>, Object> vertexMap = new SimpleHashMap<>();

    public void addVertex(Vertex<E> vertex) {
        vertexMap.put(vertex, object);
    }

    public boolean addEdge(Vertex<E> v1, Vertex<E> v2) {
        if (!vertexMap.containsKey(v1) || !vertexMap.containsKey(v2)) {
            return false;
        }
        if (v1.getAdjacencyLink() == null) {
            v1.setAdjacencyLink(SinglyLinkedNode.of(v2));
        } else {
            SinglyLinkedNode<Vertex<E>> tail = v1.getAdjacencyLink();
            {
                if (tail.equals(v2)) {
                    return false;
                }
                tail = tail.getNext();
            } while (tail.getNext() == null);
            tail.setNext(SinglyLinkedNode.of(v2));
        }
        return true;
    }

    public SimpleHashMap<Vertex<E>, Object> getVertexMap() {
        return vertexMap;
    }
}
