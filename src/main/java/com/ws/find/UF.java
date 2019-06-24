package com.ws.find;

public class UF {
    // 分量ID
    private int[] id;
    // 分量数量
    private int count;

    UF(int N) {
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

    int find(int p) {
        return id[p];
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }

    public static void main(String[] args) {
        UF uf = new UF(10);
        Integer[][] links = {{4, 3}, {3, 8}, {6, 5}, {9, 4}, {2, 1}, {5, 0}, {7, 2}, {6, 1}}; //, {1, 0}, {6, 7}};

        for (Integer[] link : links)
            uf.union(link[0], link[1]);

        System.out.println(uf.count());

        for (Integer[] link : links)
            System.out.println(uf.connected(link[0], link[1]));
    }
}
