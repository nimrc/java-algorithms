package com.ws.st;

import com.ws.base.StdOut;

import java.util.TreeMap;

public class ST<K extends Comparable<K>, V> {
    private TreeMap<K, V> st;

    ST() {
        st = new TreeMap<>();
    }

    public void put(K key, V val) {
        if (val == null)
            delete(key);
        else
            st.put(key, val);
    }

    public V get(K k) {
        return st.get(k);
    }

    public void delete(K k) {
        st.remove(k);
    }

    public boolean contains(K k) {
        return get(k) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return st.size();
    }

    public K min() {
        return st.firstKey();
    }

    public K max() {
        return st.lastKey();
    }

    public K floor(K key) {
        return st.floorKey(key);
    }

    public K ceiling(K key) {
        return st.ceilingKey(key);
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    Iterable<K> keys() {
        return st.keySet();
    }

    @Override
    public String toString() {
        return st.toString();
    }
}
