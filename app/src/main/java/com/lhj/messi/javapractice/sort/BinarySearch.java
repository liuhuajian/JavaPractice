package com.lhj.messi.javapractice.sort;

/**
 * Created by messi on 2017/7/21.
 */

public class BinarySearch {
    public static int getIndexFromArrays(int[] arrays, int des) {
        int low = 0;
        int high = arrays.length - 1;
        while (low <= high) {
            int middle = (high + low) >> 1;
            if (des == arrays[middle]) {
                return middle;
            } else if (des < arrays[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static int getIndexFromArraysRecursion(int[] arrays, int dex) {
        int index = getIndex(arrays, 0, arrays.length - 1, dex);
        return index;
    }

    private static int getIndex(int[] arrays, int low, int high, int dex) {
        if (low <= high) {
            int middle = (high + low) >> 1;
            if (dex == arrays[middle]) {
                return middle;
            } else if (dex > arrays[middle]) {
                return getIndex(arrays, middle + 1, high, dex);
            } else {
                return getIndex(arrays, low, middle - 1, dex);
            }
        } else {
            return -1;
        }
    }
}
