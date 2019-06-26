package com.ws.tree;

import com.ws.base.StdOut;
import junit.framework.TestCase;

public class TreeTest extends TestCase {
    public void testBinarySearchTree() {
        BST<Character, Character> bst = new BST<>();
        String str = "SIMPLEBST";

        for (int i = 0; i < str.length(); i++)
            bst.put(str.charAt(i), str.charAt(i));

        assertEquals(8, bst.size());
        assertEquals("BEILMPST", bst.preOrder());

        assertEquals(new Character('B'), bst.min());
        assertEquals(new Character('T'), bst.max());

        assertEquals(new Character('S'), bst.get('S'));
        assertNull(bst.get('A'));
    }
}
