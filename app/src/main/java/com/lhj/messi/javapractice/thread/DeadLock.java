package com.lhj.messi.javapractice.thread;

import com.lhj.messi.javapractice.util.Logger;

/**
 * Created by messi on 2017/7/22.
 */

public class DeadLock {

    public void postDeadLock(){
        Thread thread1 = new Thread(new DeadRunnable(true));
        Thread thread2 = new Thread(new DeadRunnable(false));
        thread1.start();
        thread2.start();
    }

    private class DeadRunnable implements Runnable{

        private boolean flag;
        private ObjState objState;
        public DeadRunnable(boolean flag) {
            // TODO Auto-generated constructor stub
            this.flag = flag;
            objState = new ObjState();
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (flag) {
                while(true){
                    synchronized (objState.objA) {
                        Logger.d("if objA");
                        synchronized (objState.objB) {
                            Logger.d("if objB");
                        }
                    }
                }
            }else {
                while(true){
                    synchronized (objState.objB) {
                        Logger.d("else objB");
                        synchronized (objState.objA) {
                            Logger.d("else objA");
                        }
                    }
                }
            }
        }
    }

    private class ObjState{
        public  Object objA = new Object();
        public  Object objB = new Object();
    }
}




