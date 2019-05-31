package com.ws.sort;

/**
 * 插入排序
 */
public class InsertionSort extends BaseSort {
    @Override
    public void sort(Comparable[] array) {
        int len = array.length;

        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--)
                swap(array, j, j - 1);
        }
    }

    public static void main(String[] args) {
        run(new InsertionSort());
    }
}
