package com.ws.sort;

import com.ws.base.StdOut;
import junit.framework.TestCase;

public class SortTest extends TestCase {
    public void testSelectionSort() {
        run("Selection Sort", new SelectionSort());
    }

    public void testInsertionSort() {
        run("Insertion Sort", new InsertionSort());
    }

    public void testShellSort() {
        run("Shell Sort", new ShellSort());
    }

    public void testQuickSort() {
        run("Quick Sort", new QuickSort());
    }

    private static void run(String title, BaseSort sorter) {
        StdOut.println(title);

        Integer[] unsorted = {31, 41, 59, 26, 53, 58, 97, 93};
        BaseSort.showProcess();
        sorter.sort(unsorted);
        show(unsorted);
        assert isSorted(unsorted);
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

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
