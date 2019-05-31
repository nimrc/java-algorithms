package com.ws.st;

public class BinarySearchST<K extends Comparable<K>, V> {
    private K[] keys;
    private V[] vals;

    private int N;

    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        vals = (V[]) new Comparable[capacity];
    }

    public V get(K key) {
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];

        return null;
    }

    public void put(K key, V val) {
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
            keys[i] = key;
            vals[i] = val;
            N++;
        }
    }

    public int rank(K key) {
        return 0;
    }

    public int size() {
        return N;
    }
}
