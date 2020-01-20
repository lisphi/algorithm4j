package com.lishaopeng.algorithm.tree.binary.traversal;

import com.lishaopeng.algorithm.tree.binary.BinaryTreeIterator;
import com.lishaopeng.algorithm.tree.binary.BinaryTreeNode;

public class InOrderBinaryTreeIterator<E> extends BinaryTreeIterator<E> {
    public InOrderBinaryTreeIterator(BinaryTreeNode<E> root) {
        traverse(root);
        dumpStack();
    }

    private void traverse(BinaryTreeNode<E> root) {
        if (root == null) {
            return;
        }
        traverse(root.getLeft());
        tempStack.push(root.getData());
        traverse(root.getRight());
    }
}