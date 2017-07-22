package com.lhj.messi.javapractice.sort;

import com.lhj.messi.javapractice.util.Print;

/**
 * Created by messi on 2017/7/21.
 */

public class QuickSorted {
    public static void getQuickValue(int[] arrays){
        Print.printArrys(arrays);
        putThisMethod(arrays,0,arrays.length-1);
        Print.printArrys(arrays);
    }



    private static void putThisMethod(int[] arrays,int start,int end){
        if (start <end){
            int middle = getMiddle(arrays,start,end);
            putThisMethod(arrays,start,middle-1);
            putThisMethod(arrays,middle+1,end);
        }
    }

    private static int getMiddle(int[] arrays,int start,int end){
        int temp = arrays[start];
        while (start <end){
            while (temp < arrays[end] &&start <end){
                end--;
            }
            arrays[start] = arrays[end];
            while (temp > arrays[start] && start <end){
                start++;
            }
            arrays[end] = arrays[start];
        }
        arrays[start] = temp;
        return start;
    }
}
