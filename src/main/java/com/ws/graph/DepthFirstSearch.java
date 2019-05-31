package com.ws.graph;

import com.ws.base.StdOut;

public class DepthFirstSearch {
    private boolean[] marked;

    private int count;

    private DepthFirstSearch(Graph G, int start) {
        marked = new boolean[G.V()];

        dfs(G, start);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;

        StdOut.println((char) v);
        count++;

        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }

    private int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(100);

        /*
         *      / B - D
         *    A   | / |  \
         *      \ C - E   F
         */
        char[][] v = {{'A', 'B'}, {'B', 'C'}, {'A', 'C'}, {'B', 'D'}, {'C', 'D'}, {'C', 'E'}, {'D', 'E'}, {'D', 'F'}};

        for (char[] x : v)
            graph.addEdge(x[0], x[1]);

        // 深度优先搜索
        new DepthFirstSearch(graph, 'A');
    }
}
