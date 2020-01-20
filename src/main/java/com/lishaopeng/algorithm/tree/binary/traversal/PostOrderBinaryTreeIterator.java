package com.lishaopeng.algorithm.tree.binary.traversal;

import com.lishaopeng.algorithm.tree.binary.BinaryTreeIterator;
import com.lishaopeng.algorithm.tree.binary.BinaryTreeNode;

public class PostOrderBinaryTreeIterator<E> extends BinaryTreeIterator<E> {
    public PostOrderBinaryTreeIterator(BinaryTreeNode<E> root) {
        traverse(root);
        dumpStack();
    }

    private void traverse(BinaryTreeNode<E> root) {
        if (root == null) {
            return;
        }
        traverse(root.getLeft());
        traverse(root.getRight());
        tempStack.push(root.getData());
    }
}
