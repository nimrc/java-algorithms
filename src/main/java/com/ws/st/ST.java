package com.ws.st;

import com.ws.base.StdOut;

import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> {
    private TreeMap<Key, Value> st;

    ST() {
        st = new TreeMap<>();
    }

    void put(Key key, Value val) {
        if (val == null)
            delete(key);
        else
            st.put(key, val);
    }

    Value get(Key key) {
        return st.get(key);
    }

    private void delete(Key key) {
        st.remove(key);
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return size() != 0;
    }

    private int size() {
        return st.size();
    }

    private Key min() {
        return st.firstKey();
    }

    private Key max() {
        return st.lastKey();
    }

    Key floor(Key key) {
        return st.floorKey(key);
    }

    Key ceiling(Key key) {
        return st.ceilingKey(key);
    }

    private void deleteMin() {
        delete(min());
    }

    private void deleteMax() {
        delete(max());
    }

    Iterable<Key> keys() {
        return st.keySet();
    }

    public static void main(String[] args) {
        ST<Character, Integer> st = new ST<>();

        String s = "SEARCHEXAMPLE";


        for (int i = 0; i < s.length(); i++)
            st.put(s.charAt(i), i);

        StdOut.println("min key: " + st.min());
        StdOut.println("max key: " + st.max());

        st.deleteMax();
        st.deleteMin();

        for (Character x : st.keys()) {
            StdOut.println(x + " " + st.get(x));
        }
    }
}
