package com.ws.sort;

/**
 * 选择排序
 */
public class SelectionSort extends BaseSort {
    @Override
    public void sort(Comparable[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            int min = i;

            for (int j = i + 1; j < len; j++)
                if (less(array[j], array[min])) min = j;

            swap(array, i, min);
        }
    }
}
