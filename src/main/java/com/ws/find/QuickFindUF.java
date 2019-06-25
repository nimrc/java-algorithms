/* *
 * Quick Find 算法
 * */
package com.ws.find;

import com.ws.base.StdIn;
import com.ws.base.StdOut;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class QuickFindUF {
    // 分量ID
    private int[] id;
    // 分量数量
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];

        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);

        if (p == q) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }

        count--;
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    /**
     * Returns true if the the two sites are in the same component.
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public static void main(String[] args) throws IOException {
        URL path = QuickFindUF.class.getClassLoader().getResource(args[0]);
        if (path != null) {
            Scanner scanner = new Scanner(new FileReader(new File(path.getPath())));
            int N = scanner.nextInt();
            QuickFindUF uf = new QuickFindUF(N);

            long start = System.currentTimeMillis();

            while (scanner.hasNext()) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();

                if (uf.connected(p, q))
                    continue;

                uf.union(p, q);

                StdOut.println(p + " " + q);
            }

            StdOut.println(uf.count() + " components");

            StdOut.println("执行耗时 : " + (System.currentTimeMillis() - start) / 1000f + " 秒 ");
        }
    }
}
