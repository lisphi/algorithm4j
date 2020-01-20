package com.lishaopeng.algorithm.tree.binary.traversal;

import com.lishaopeng.algorithm.linear.queue.ArrayQueue;
import com.lishaopeng.algorithm.linear.queue.CocoaQueue;
import com.lishaopeng.algorithm.tree.binary.BinaryTreeNode;
import com.lishaopeng.algorithm.tree.binary.BinaryTreeIterator;

public class BreadthFirstBinaryTreeIterator<E> extends BinaryTreeIterator<E> {
    public BreadthFirstBinaryTreeIterator(BinaryTreeNode<E> root) {
        traverse(root);
        dumpStack();
    }

    private void traverse(BinaryTreeNode<E> root) {
        CocoaQueue<BinaryTreeNode<E>> cocoaQueue = new ArrayQueue<>();
        cocoaQueue.offer(root);
        while (cocoaQueue.size() > 0) {
            BinaryTreeNode<E> node = cocoaQueue.poll();
            tempStack.push(node.getData());
            if (node.getLeft() != null) {
                cocoaQueue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                cocoaQueue.offer(node.getRight());
            }
        }
    }
}
