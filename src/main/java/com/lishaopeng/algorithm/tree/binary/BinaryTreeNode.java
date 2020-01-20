package com.lishaopeng.algorithm.tree.binary;

public class BinaryTreeNode<E> {
    private E data;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<E> left) {
        this.left = left;
    }

    public BinaryTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<E> right) {
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    static public <E> BinaryTreeNode<E> of(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        return new BinaryTreeNode<>(data, left, right);
    }

    static public <E> BinaryTreeNode<E> of(E data) {
        return new BinaryTreeNode<E>(data, null, null);
    }
}
