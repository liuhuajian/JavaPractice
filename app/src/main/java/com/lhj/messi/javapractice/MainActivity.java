package com.lhj.messi.javapractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lhj.messi.javapractice.sort.BinarySearch;
import com.lhj.messi.javapractice.sort.QuickSorted;
import com.lhj.messi.javapractice.thread.DeadLock;
import com.lhj.messi.javapractice.thread.ProductCustomerApp;
import com.lhj.messi.javapractice.thread.ProductCustomerLockApp;
import com.lhj.messi.javapractice.thread.ThreadCommunication;
import com.lhj.messi.javapractice.util.Logger;

public class MainActivity extends AppCompatActivity {

    private ThreadCommunication threadCommunication;
    private ProductCustomerApp productCustomerApp;
    private ProductCustomerLockApp productCustomerLockApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        productCustomerLockApp = new ProductCustomerLockApp();
        productCustomerLockApp.setProductWithCustomer();
//        productCustomerApp = new ProductCustomerApp();
//        productCustomerApp.setProductWithCustomer();
//        threadCommunication = new ThreadCommunication();
//        threadCommunication.displayThreadCommunication();
//        new DeadLock().postDeadLock();
//        int[] arrays = {33,1,22,5,7,32,11,88,102};
//        QuickSorted.getQuickValue(arrays);
//        int indexFromArrays = BinarySearch.getIndexFromArrays(arrays, 33);
//        int indexFromArrays = BinarySearch.getIndexFromArraysRecursion(arrays, 33);
//        Logger.d("index-->"+indexFromArrays);

//        SelectSorted.getSelectSort(arrays);
//        MaoPaoSorted.sortNumberMaoPao(arrays);
    }

    public void btnClickStop(View view) {
        productCustomerLockApp.instantFlag = false;
//        productCustomerApp.instantFlag = false;
//        threadCommunication.flag = false;
    }
}
