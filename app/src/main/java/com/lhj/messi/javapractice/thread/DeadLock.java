package com.lhj.messi.javapractice.thread;

import com.lhj.messi.javapractice.util.Logger;

/**
 * Created by messi on 2017/7/22.
 */

public class DeadLock {
    public static void postDeadLock(){
        Thread thread1 = new Thread(new DeadRunnable(true));
        Thread thread2 = new Thread(new DeadRunnable(false));
        thread1.start();
        thread2.start();
    }
}

class DeadRunnable implements Runnable{

    private boolean flag;
    public DeadRunnable(boolean flag) {
        // TODO Auto-generated constructor stub
        this.flag = flag;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if (flag) {
            while(true){
                synchronized (ObjState.objA) {
                    Logger.d("if objA");
                    synchronized (ObjState.objB) {
                        Logger.d("if objB");
                    }
                }
            }
        }else {
            while(true){
                synchronized (ObjState.objB) {
                    Logger.d("else objB");
                    synchronized (ObjState.objA) {
                        Logger.d("else objA");
                    }
                }
            }
        }
    }
}

class ObjState{
    public static Object objA = new Object();
    public static Object objB = new Object();
}


