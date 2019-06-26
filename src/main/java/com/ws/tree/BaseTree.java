package com.ws.tree;

public abstract class BaseTree<K extends Comparable<K>, V> {
    Node root;               // root of BST

    class Node {
        K key;              // sorted by key
        V val;              // associated data
        Node left, right;   // left and right subtrees
        int size;           // number of nodes in subtree

        Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public String preOrder() {
        return preOrder(root);
    }

    public String preOrder(Node node) {
        if (node == null) return "";

        return preOrder(node.left) + node.val + preOrder(node.right);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;

        return max(node.right);
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;

        return min(node.left);
    }

    public K floor(K key) {
        Node node = floor(root, key);

        if (node == null) return null;

        return node.key;
    }

    public Node floor(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);

        if (cmp == 0) return node;

        if (cmp < 0) return floor(node.left, key);

        Node t = floor(node.right, key);

        if (t != null) return t;

        return node;
    }

}
