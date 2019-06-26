/*
 * 有序符号表
 * Ordered symbol table
 */
package com.ws.st;

import com.ws.base.StdOut;
import junit.framework.TestCase;

public class STTest extends TestCase {
    public void testST() {
        ST<Character, Integer> st = new ST<>();
        String str = "SEARCHEXAMPLE";

        for (int i = 0; i < str.length(); i++)
            st.put(str.charAt(i), i);

        StdOut.println("symbol table: " + st);

        assertEquals(10, st.size());

        StdOut.println("min key: " + st.min());
        StdOut.println("max key: " + st.max());

        StdOut.println("floor(A): " + st.floor('A'));
        StdOut.println("ceiling(A): " + st.ceiling('A'));

        st.deleteMax();
        st.deleteMin();

        StdOut.println("symbol table: " + st);

        assertEquals(8, st.size());

        assertFalse(st.isEmpty());
    }

    public void testSequentialSearchST() {
        SequentialSearchST<Character, Character> st = new SequentialSearchST<>();
        String str = "ABCDEFGHIJKLMN";

        for (int i = 0; i < str.length(); i++)
            st.put(str.charAt(i), str.charAt(i));

        StdOut.println("st: " + st);

        assertEquals(new Character('L'), st.get('L'));
        assertNull(st.get('O'));
    }

    public void testBinarySearchST() {
        BinarySearchST<Character, Character> bst = new BinarySearchST<>(15);
        String str = "ABCDEFGHIJKLMN";

        for (int i = 0; i < str.length(); i++)
            bst.put(str.charAt(i), str.charAt(i));

        assertEquals(str.length(), bst.size());

        StdOut.println("bst: " + bst);
    }
}
