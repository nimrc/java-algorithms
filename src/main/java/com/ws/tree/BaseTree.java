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
}
