package com.lhj.messi.sorted;

import com.lhj.messi.javapractice.util.Print;

/**
 * Created by messi on 2017/7/20.
 */

public class MaoPaoSorted {
    public static void sortNumberMaoPao(int[] arrays){
        for (int i=0;i<arrays.length;i++){
            for (int j=0;j<arrays.length-i-1;j++){
                if (arrays[j] >arrays[j+1]){
                    arrays[j] = arrays[j] ^arrays[j+1];
                    arrays[j+1] = arrays[j] ^arrays[j+1];
                    arrays[j] = arrays[j] ^arrays[j+1];
                }
            }
        }
        Print.printArrys(arrays);
    }
}
