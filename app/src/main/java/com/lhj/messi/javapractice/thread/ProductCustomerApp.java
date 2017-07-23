package com.lhj.messi.javapractice.thread;

import com.lhj.messi.javapractice.util.Logger;

/**
 * Created by messi on 2017/7/23.
 */

public class ProductCustomerApp {

    public boolean instantFlag = true;

    public void setProductWithCustomer(){
        Rescourse rescourse = new Rescourse();
        Customer customer = new Customer(rescourse);
        Producter producter = new Producter(rescourse);
        Thread thread1 = new Thread(customer);
        Thread thread2 = new Thread(customer);
        Thread thread3 = new Thread(producter);
        Thread thread4 = new Thread(producter);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    private class Rescourse{
        private String name;
        private int count;
        private boolean flag;
        public synchronized void set(String name){
            while (flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name+"..."+(count++);
            Logger.d(Thread.currentThread().getName()+"........生产者......."+this.name);

            flag = true;
            notifyAll();
        }

        public synchronized void out(){
            while (!flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Logger.d(Thread.currentThread().getName()+"+++消费者+++"+name);
            flag = false;
            notifyAll();
        }
    }

    private class Customer implements Runnable{

        private Rescourse rescourse;
        Customer(Rescourse rescourse){
            this.rescourse = rescourse;
        }
        @Override
        public void run() {
            while (instantFlag){
                rescourse.out();
            }
        }
    }

    private class Producter implements Runnable{
        private Rescourse rescourse;
        Producter(Rescourse rescourse){
            this.rescourse = rescourse;
        }
        @Override
        public void run() {
            while (instantFlag){
                rescourse.set("....商品...");
            }
        }
    }
}
