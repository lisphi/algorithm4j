package com.lishaopeng.algorithm.tree.binary.traversal;

import com.lishaopeng.algorithm.linear.stack.ArrayStack;
import com.lishaopeng.algorithm.tree.binary.BinaryTreeNode;
import com.lishaopeng.algorithm.tree.binary.BinaryTreeIterator;

public class DeepFirstBinaryTreeIterator<E> extends BinaryTreeIterator<E> {
    public DeepFirstBinaryTreeIterator(BinaryTreeNode<E> root) {
        traverse(root);
        dumpStack();
    }

    private void traverse(BinaryTreeNode<E> root) {
        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<E> node = stack.pop();
            tempStack.push(node.getData());
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
    }
}
