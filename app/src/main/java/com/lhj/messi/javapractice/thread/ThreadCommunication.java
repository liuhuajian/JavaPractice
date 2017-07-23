package com.lhj.messi.javapractice.thread;

import com.lhj.messi.javapractice.util.Logger;

/**
 * Created by messi on 2017/7/22.
 */

public class ThreadCommunication {

    public boolean flag = true;

    public void displayThreadCommunication() {
        Student student = new Student();
        Input input = new Input(student);
        OutPut outPut = new OutPut(student);
        Thread thread1 = new Thread(input);
        Thread thread2 = new Thread(outPut);
        thread1.start();
        thread2.start();
    }

    private class Student {
        public String name;
        public String sex;
        public boolean flag;
    }

    private class Input implements Runnable {
        private Student student;

        public Input(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            int x = 0;
            while (flag) {
                synchronized (student){
                    if (student.flag) {
                        try {
                            student.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x == 0) {
                        student.name = "刘华健";
                        student.sex = "man";
                    } else {
                        student.name = "马蓉";
                        student.sex = "woman";
                    }
                    x = (x + 1) % 2;
                    student.flag = true;
                    student.notify();
                }

            }
        }
    }

    private class OutPut implements Runnable {

        private Student student;

        public OutPut(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            while (flag) {
                synchronized (student){
                    if (!student.flag){
                        try {
                            student.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Logger.d("name--->" + student.name + "--sex-->" + student.sex);
                    student.flag = false;
                    student.notify();
                }

            }
        }
    }
}
