package com.lishaopeng.algorithm.tree.binary;

import com.lishaopeng.algorithm.linear.stack.ArrayStack;

import java.util.Iterator;

public class BinaryTreeIterator<E> implements Iterator<E> {
    protected ArrayStack<E> stack = new ArrayStack<>();
    protected ArrayStack<E> tempStack = new ArrayStack<>();
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public E next() {
        return stack.pop();
    }

    protected void dumpStack() {
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
