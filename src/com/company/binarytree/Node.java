package com.company.binarytree;

public class Node {
    private Node left;
    private Node right;
    private Integer data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(final Integer data) {
        this.data = data;
    }
}
