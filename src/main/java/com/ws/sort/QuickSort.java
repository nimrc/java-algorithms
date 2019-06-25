package com.ws.sort;

public class QuickSort extends BaseSort {
    @Override
    public void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] array, int low, int high) {
        if (high <= low) return;

        int j = partition(array, low, high);

        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }

    private static int partition(Comparable[] array, int low, int high) {
        int i = low;
        int j = high + 1;

        Comparable v = array[low];

        while (true) {
            while (less(array[++i], v))
                if (i == high) break;

            while (less(v, array[--j]))
                if (j == low) break;

            if (i >= j)
                break;

            swap(array, i, j);
        }

        swap(array, low, j);

        return j;
    }
}
