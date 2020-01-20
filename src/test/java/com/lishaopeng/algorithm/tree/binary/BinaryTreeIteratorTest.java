package com.lishaopeng.algorithm.tree.binary;

import com.lishaopeng.algorithm.tree.binary.traversal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeIteratorTest {
    BinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        BinaryTreeNode<Integer> node1 = BinaryTreeNode.of(1);
        BinaryTreeNode<Integer> node2 = BinaryTreeNode.of(2);
        BinaryTreeNode<Integer> node3 = BinaryTreeNode.of(3);
        BinaryTreeNode<Integer> node4 = BinaryTreeNode.of(4);
        BinaryTreeNode<Integer> node5 = BinaryTreeNode.of(5);
        BinaryTreeNode<Integer> node6 = BinaryTreeNode.of(6);
        BinaryTreeNode<Integer> node7 = BinaryTreeNode.of(7);
        BinaryTreeNode<Integer> node8 = BinaryTreeNode.of(8);
        BinaryTreeNode<Integer> node9 = BinaryTreeNode.of(9);
        BinaryTreeNode<Integer> node10 = BinaryTreeNode.of(10);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node4.setRight(node9);
        node5.setLeft(node10);
        root = node1;
    }


    @Test
    void testPreOrderIterator() {
        BinaryTreeIterator<Integer> iterator = new PreOrderBinaryTreeIterator<>(root);
        int[] datas = new int[] { 1, 2, 4, 8, 9, 5, 10, 3, 6, 7 };
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(datas[i++], iterator.next());
        }
    }

    @Test
    void testInOrderIterator() {
        BinaryTreeIterator<Integer> iterator = new InOrderBinaryTreeIterator<>(root);
        int[] datas = new int[] { 8, 4, 9, 2, 10, 5, 1, 6, 3, 7 };
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(datas[i++], iterator.next());
        }
    }

    @Test
    void testPostOrderIterator() {
        BinaryTreeIterator<Integer> iterator = new PostOrderBinaryTreeIterator<>(root);
        int[] datas = new int[] { 8, 9, 4, 10, 5, 2, 6, 7, 3, 1 };
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(datas[i++], iterator.next());
        }
    }

    @Test
    void testDeepFirstIterator() {
        BinaryTreeIterator<Integer> iterator = new DeepFirstBinaryTreeIterator<>(root);
        int[] datas = new int[] { 1, 3, 7, 6, 2, 5, 10, 4, 9, 8 };
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(datas[i++], iterator.next());
        }
    }

    @Test
    void testBreadthFirstIterator() {
        BinaryTreeIterator<Integer> iterator = new BreadthFirstBinaryTreeIterator<>(root);
        int[] datas = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(datas[i++], iterator.next());
        }
    }
}