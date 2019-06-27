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

        // order
        assertEquals("BEILMPST", bst.preOrder().toString());
        assertEquals("SIEBMLPT", bst.inOrder().toString());
        assertEquals("BELPMITS", bst.postOrder().toString());

        assertEquals(new Character('B'), bst.min());
        assertEquals(new Character('T'), bst.max());

        bst.deleteMin();
        bst.deleteMax();
        assertEquals("EILMPS", bst.preOrder().toString());

        bst.delete('M');
        assertEquals("EILPS", bst.preOrder().toString());

        assertEquals(new Character('S'), bst.get('S'));
        assertNull(bst.get('A'));
    }
}
