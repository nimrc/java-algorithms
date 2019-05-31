package com.ws.st;

public class SequentialSearchST<K, V> {
    private Node first;

    private class Node {
        Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        K key;
        V val;
        Node next;
    }

    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }

        return null;
    }

    public void put(K key, V val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.val)) {
                x.val = val;

                return;
            }
        }

        first = new Node(key, val, first);
    }
}
