package com.ws.find;

import com.ws.base.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class UF {
    private int[] parent;

    private byte[] rank;

    private int count;

    public UF(int N) {
        if (N < 0) throw new IllegalArgumentException();

        count = N;
        parent = new int[N];
        rank = new byte[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     */
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = find(parent[p]);
        }

        return parent[p];
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return false;

        if (rank[rootP] < rank[rootQ])
            parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ])
            parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;

        return true;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        URL path = QuickFindUF.class.getClassLoader().getResource(args[0]);

        if (path != null) {
            Scanner scanner = new Scanner(new FileReader(new File(path.getPath())));
            int N = scanner.nextInt();
            UF uf = new UF(N);

            long start = System.currentTimeMillis();

            while (scanner.hasNext()) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();

                if (uf.connected(p, q)) continue;

                uf.union(p, q);

                StdOut.println(p + "  " + q);
            }

            StdOut.println(uf.count() + " components");

            StdOut.println("执行耗时 : " + (System.currentTimeMillis() - start) / 1000f + " 秒 ");
        }
    }
}
