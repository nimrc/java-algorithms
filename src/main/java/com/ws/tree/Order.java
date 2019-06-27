package com.ws.tree;

import java.util.ArrayList;

import com.ws.tree.BaseTree.Node;

public class Order<T> extends ArrayList<T> {
    /**
     * 先序遍历
     *
     * @param tree binary tree
     * @return Iterable
     */
    public static Order<Node> preOrder(BaseTree tree) {
        if (tree.root == null) return null;

        Order<Node> order = new Order<>();
        preOrder(order, tree.root);

        return order;
    }

    /**
     * 中序遍历
     *
     * @param tree binary tree
     * @return Iterable
     */
    public static Order<Node> inOrder(BaseTree tree) {
        if (tree.root == null) return null;

        Order<Node> order = new Order<>();
        inOrder(order, tree.root);

        return order;
    }

    /**
     * 后序遍历
     *
     * @param tree binary tree
     * @return Iterable
     */
    public static Order<Node> postOrder(BaseTree tree) {
        if (tree.root == null) return null;

        Order<Node> order = new Order<>();
        postOrder(order, tree.root);

        return order;
    }


    private static void preOrder(Order<Node> order, Node node) {
        if (node == null) return;

        preOrder(order, node.left);
        order.add(node);
        preOrder(order, node.right);
    }

    private static void inOrder(Order<Node> order, Node node) {
        if (node == null) return;

        order.add(node);
        inOrder(order, node.left);
        inOrder(order, node.right);
    }

    private static void postOrder(Order<Node> order, Node node) {
        if (node == null) return;

        postOrder(order, node.left);
        postOrder(order, node.right);
        order.add(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T node : this) sb.append(node.toString());
        return sb.toString();
    }
}
