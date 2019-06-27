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

        @Override
        public String toString() {
            return val.toString();
        }
    }

    public Iterable preOrder() {
        return Order.preOrder(this);
    }

    public Iterable postOrder() {
        return Order.postOrder(this);
    }

    public Iterable inOrder() {
        return Order.inOrder(this);
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

    // 删除最小节点
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;

        node.left = deleteMin(node.left);
        node.size = resize(node);

        return node;
    }

    // 删除最大节点
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;

        node.right = deleteMax(node.right);
        node.size = resize(node);

        return node;
    }

    // 删除指定节点
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.size = resize(node);

        return node;
    }

    public int size() {
        return size(root);
    }

    int resize(Node node) {
        return size(node.left) + size(node.right) + 1;
    }

    int size(Node node) {
        if (node == null) return 0;

        return node.size;
    }
}
