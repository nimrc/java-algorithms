package com.ws.graph;

import com.ws.base.StdOut;

public class Graph {

    private final int V;

    private int E;

    private Bag<Integer>[] adj;

    Graph(int V) {
        this.V = V;
        this.E = 0;

        adj = (Bag<Integer>[]) new Bag[V];

        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }


    int V() {
        return V;
    }

    private int E() {
        return E;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);

        E++;
    }

    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // 图的邻接表的字符串表示（Graph 的实例方法）
    public String toString() {
        return "";
    }

    // 计算v的度数
    private static int degree(Graph G, int v) {
        int degree = 0;

        for (int w : G.adj(v))
            degree++;

        return degree;
    }

    // 计算所有顶点的最大度数
    public static int maxDegree(Graph G) {
        int max = 0;

        for (int v = 0; v < G.V(); v++)
            if (degree(G, v) > max)
                max = degree(G, v);

        return max;
    }

    public static double avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

//    // 计算自环的个数
//    public static int numberOfSelfLoops(Graph G) {
//    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);

        Integer[][] v = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4}, {5, 4}, {0, 2}, {11, 12}, {9, 10}, {0, 6}, {7, 8}, {9, 11}, {5, 3}};

        for (Integer[] x : v)
            graph.addEdge(x[0], x[1]);

    }
}
