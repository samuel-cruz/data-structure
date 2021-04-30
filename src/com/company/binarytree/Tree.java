package com.company.binarytree;

import java.util.Random;

public class Tree {

    private int height(Node root) {
        int h = 0;
        if (root != null && root.getRight() != null)
            if (root.getRight().getData() > root.getData())
                h = height(root.getRight()) + 1;

        return h;
    }

    private Node insert(Node root, Integer data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data < root.getData()) {
                cur = insert(root.getLeft(), data);
                root.setLeft(cur);
            } else if (data > root.getData()){
                cur = insert(root.getRight(), data);
                root.setRight(cur);
            }
            return root;
        }
    }

    /**
     * The algorithm for sorting a binary tree, starting from left to top, then right
     *       T
     *      /\
     *     /  \
     *    /    \
     *   /      \
     *  L        R
     *
     */
    private void showInOrder(Node root) {
        if (root != null) {
            showInOrder(root.getLeft());
            System.out.println("    > " + root.getData());
            showInOrder(root.getRight());
        }
    }

    /**
     * The algorithm for sorting a binary tree, starting from top for left, then right
     *     T
     *    /
     *   /
     *  /
     * L ----------- R
     *
     */
    private void showInPreOrder(Node root) {
        if (root != null) {
            System.out.println("    > " + root.getData());
            showInPreOrder(root.getLeft());
            showInPreOrder(root.getRight());
        }
    }

    /**
     * The algorithm for sorting a binary tree, starting from left to right, then up
     *         T
     *          \
     *           \
     *            \
     *             \
     *  L --------- R
     *
     */
    private void showInPostOrder(Node root) {
        if (root != null) {
            showInPreOrder(root.getLeft());
            showInPreOrder(root.getRight());
            System.out.println("    > " + root.getData());
        }
    }

    public void process() {
        Node root = null;

        System.out.println("Elements in the tree");
        for (Integer i = 0; i < 10; i++) {
            int element = new Random().nextInt(100);
            System.out.println("  > " + element);
            root = insert(root, element);
        }

        System.out.println("\nSort Algorithms");
        System.out.println("  > Height of tree: " + height(root));

        System.out.println("\n  > In ordem");
        showInOrder(root);
        System.out.println("\n  > Pre-ordem");
        showInPreOrder(root);
        System.out.println("\n  > Post-ordem");
        showInPostOrder(root);
    }
}