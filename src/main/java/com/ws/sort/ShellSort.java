package com.ws.sort;

public class ShellSort extends BaseSort {
    @Override
    public void sort(Comparable[] array) {
        int len = array.length;
        int h = 1;

        while (h < len / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    swap(array, j, j - h);
                }
            }

            h /= 3;
        }
    }
}
