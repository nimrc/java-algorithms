/*
 * binary search tree
 */
package com.ws.tree;

public class BST<K extends Comparable<K>, V> extends BaseTree<K, V> {
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) return get(node.left, key);

        if (cmp > 0) return get(node.right, key);

        return node.val;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) return new Node(key, val, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, val);
        else if (cmp > 0) node.right = put(node.right, key, val);
        else node.val = val;

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }
}
