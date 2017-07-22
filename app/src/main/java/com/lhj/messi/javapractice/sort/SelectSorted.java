package com.lhj.messi.javapractice.sort;

import com.lhj.messi.javapractice.util.Print;

/**
 * Created by messi on 2017/7/21.
 */

public class SelectSorted {
    public static void getSelectSort(int[] arrays){
        for (int i=0;i<arrays.length-1;i++){
            for (int j=i;j<arrays.length;j++){
                if (arrays[i] > arrays[j]){
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        Print.printArrys(arrays);
    }
}
