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
        if (root == null)
            return new Node(data);
        else {
            Node cur;
            if (data < root.getData()) {
                cur = insert(root.getLeft(), data);
                root.setLeft(cur);
            } else if (data > root.getData()) {
                cur = insert(root.getRight(), data);
                root.setRight(cur);
            }
            return root;
        }
    }

    private boolean remove(Node root, Integer data) {
        return false;
    }

    private Node findNodeByValue(Node root, Integer data) {
        while (root != null) {
            if (root.getData().equals(data)) {
                return root;
            } else if (data.compareTo(root.getData()) == -1) {
                return findNodeByValue(root.getLeft(), data);
            } else {
                return findNodeByValue(root.getRight(), data);
            }
        }

        return null;
    }

    private Node findOwnerNode(Node root, Node owner, Node node) {
        while (root != null) {
            if (root.getData().equals(node.getData()))
                return null;

            if (root.getRight() != null) {
                if (root.getRight().getData().equals(node.getData()))
                    return root;
                else if (root.getRight().getData().compareTo(node.getData()) > 0)
                    return findOwnerNode(root.getRight(), root, node);
            }

            if (root.getLeft() != null) {
                if (root.getLeft().getData().equals(node.getData()))
                    return root;
                else if (root.getLeft().getData().compareTo(node.getData()) < 0)
                    return findOwnerNode(root.getLeft(), root, node);
            }

            if (root.getRight() == null && root.getLeft() == null)
                return owner;
        }
        return null;
    }

    /**
     * The algorithm for sorting a binary tree, starting from left to top, then right
     * T
     * /\
     * /  \
     * /    \
     * /      \
     * L        R
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
     * T
     * /
     * /
     * /
     * L ----------- R
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
     * T
     * \
     * \
     * \
     * \
     * L --------- R
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
        final int maxIndex = 5;
        final int indexRandom = new Random().nextInt(maxIndex);
        int valueToRemoveFromTheTree = 0;

        System.out.println("Elements in the tree");
        for (int index = 0; index < maxIndex; index++) {
            int element = new Random().nextInt(100);
            System.out.println("  > " + element);
            root = insert(root, element);

            if (index == indexRandom)
                valueToRemoveFromTheTree = element;
        }

        /*System.out.println("\nSort Algorithms");
        System.out.println("  > Height of tree: " + height(root));

        System.out.println("\n  > In ordem");
        showInOrder(root);
        System.out.println("\n  > Pre-ordem");
        showInPreOrder(root);
        System.out.println("\n  > Post-ordem");
        showInPostOrder(root);
        */

        System.out.println("\nValor a ser removido: " + valueToRemoveFromTheTree);
        /*
        System.out.println("\n  > Nó encontrado");
        showInOrder(nodeFinded);

         */

        Node nodeFinded = findNodeByValue(root, valueToRemoveFromTheTree);
        System.out.println("\n  > Nó pai");
        Node ownerNode = findOwnerNode(root, null, nodeFinded);
        String oN = "Nó raiz";
        if (ownerNode != null)
            oN = ownerNode.getData().toString();
        System.out.println("    > " + oN);
    }
}