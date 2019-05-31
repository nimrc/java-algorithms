package com.ws.sort;

abstract class BaseSort {
    private static boolean debug = false;

    private static int seq = 0;

    public abstract void sort(Comparable[] array);

    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static void swap(Comparable[] array, int i, int j) {
        if (debug) process(array, seq++, i, j);

        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void show(Comparable[] array) {
        System.out.println("Sort result: ");
        for (Comparable c : array) System.out.print(c + " ");

        System.out.println();
    }

    private static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++)
            if (less(array[i], array[i - 1]))
                return false;

        return true;
    }

    private static void showProcess() {
        debug = true;
    }

    static void run(BaseSort sorter) {
        Integer[] unsorted = {31, 41, 59, 26, 53, 58, 97, 93};

        showProcess();

        sorter.sort(unsorted);

        show(unsorted);

        assert isSorted(unsorted);
    }

    // swap过程
    private static void process(Comparable[] array, int seq, int i, int j) {
        System.out.print(seq + ": ");

        for (int n = 0; n < array.length; n++) {
            if (n == i || n == j)
                highlight(array[n] + " ");
            else
                System.out.print(array[n] + " ");
        }

        System.out.println();
    }

    // 高光
    private static void highlight(String s) {
        System.out.printf("\u001B[32m%s\u001B[0m", s);
    }
}
