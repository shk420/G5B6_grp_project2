package com.skewed.service;

public class ModifiedBST {
    private Node root;
    private Node prev;

    public ModifiedBST() {
        root = null;
        prev = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void SkewedTree() {
        prev = null;
        convertToSkewed(root);
    }

    private void convertToSkewed(Node root) {
        if (root == null) {
            return;
        }

        convertToSkewed(root.left);

        Node _right = root.right;
        if (prev == null) {
            prev = root;
            this.root = root;
        } else {
            prev.right = root;
            prev = root;
        }
        root.left = null;
        root.right = null;
        convertToSkewed(_right);
    }


    public void display() {
        displayRec(root);
    }

    private void displayRec(Node root) {
        if (root != null) {
            displayRec(root.left);
            System.out.print(root.key + " ");
            displayRec(root.right);
        }
    }

    public class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }
}
