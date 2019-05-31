package com.ws.graph;

import com.ws.base.StdOut;
import com.ws.list.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;

    private int count;

    private BreadthFirstSearch(Graph G, int start) {
        marked = new boolean[G.V()];

        bfs(G, start);
    }

    private void bfs(Graph G, int v) {
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;

        StdOut.println((char) v);

        queue.enqueue(v);

        while (!queue.isEmpty()) {
            int s = queue.dequeue();

            for (int w : G.adj(s)) {
                if (!marked[w]) {
                    marked[w] = true;

                    StdOut.println((char) w);

                    queue.enqueue(w);
                }
            }
        }
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

        // 广度优先搜索
        new BreadthFirstSearch(graph, 'A');
    }
}
