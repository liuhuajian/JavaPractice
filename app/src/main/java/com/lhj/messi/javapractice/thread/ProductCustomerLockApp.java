package com.lhj.messi.javapractice.thread;

import com.lhj.messi.javapractice.util.Logger;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by messi on 2017/7/23.
 */

public class ProductCustomerLockApp {
    public boolean instantFlag = true;

    public void setProductWithCustomer() {
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

    private class Rescourse {
        private String name;
        private int count;
        private boolean flag;
        Lock lock = new ReentrantLock();
        Condition condition_pro = lock.newCondition();
        Condition condition_cus = lock.newCondition();

        public void set(String name) {
            lock.lock();
            try {
                while (flag) {
                    condition_pro.await();
                }
                this.name = name + "..." + (count++);
                Logger.d(Thread.currentThread().getName() + "........生产者......." + this.name);
                flag = true;
                condition_cus.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void out() {
            lock.lock();
            try {
                while (!flag) {
                    condition_cus.await();
                }
                Logger.d(Thread.currentThread().getName() + "+++消费者+++" + name);
                flag = false;
                condition_pro.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    private class Customer implements Runnable {

        private Rescourse rescourse;

        Customer(Rescourse rescourse) {
            this.rescourse = rescourse;
        }

        @Override
        public void run() {
            while (instantFlag) {
                rescourse.out();
            }
        }
    }

    private class Producter implements Runnable {
        private Rescourse rescourse;

        Producter(Rescourse rescourse) {
            this.rescourse = rescourse;
        }

        @Override
        public void run() {
            while (instantFlag) {
                rescourse.set("....美女...");
            }
        }
    }
}
