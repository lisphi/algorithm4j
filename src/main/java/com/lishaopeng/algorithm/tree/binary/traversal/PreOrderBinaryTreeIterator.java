package com.lishaopeng.algorithm.tree.binary.traversal;

import com.lishaopeng.algorithm.tree.binary.BinaryTreeIterator;
import com.lishaopeng.algorithm.tree.binary.BinaryTreeNode;

public class PreOrderBinaryTreeIterator<E> extends BinaryTreeIterator<E> {
    public PreOrderBinaryTreeIterator(BinaryTreeNode<E> root) {
        traverse(root);
        dumpStack();
    }

    private void traverse(BinaryTreeNode<E> root) {
        if (root == null) {
            return;
        }
        tempStack.push(root.getData());
        traverse(root.getLeft());
        traverse(root.getRight());
    }
}
