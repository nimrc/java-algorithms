package com.ws.st;

import java.util.Arrays;

public class BinarySearchST<K extends Comparable<K>, V extends Comparable<V>> {
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
        }

        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public int rank(K key) {
        int low = 0, high = N - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }

        return low;
    }

    public int size() {
        return N;
    }

    @Override
    public String toString() {
        return Arrays.toString(keys);
    }
}
