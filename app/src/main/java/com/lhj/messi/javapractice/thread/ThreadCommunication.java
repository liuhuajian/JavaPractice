package com.lhj.messi.javapractice.thread;

import com.lhj.messi.javapractice.util.Logger;

import java.io.OutputStream;

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
                    if (x == 0) {
                        student.name = "刘华健";
                        student.sex = "man";
                    } else {
                        student.name = "马蓉";
                        student.sex = "woman";
                    }
                    x = (x + 1) % 2;
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
                    Logger.d("name--->" + student.name + "--sex-->" + student.sex);
                }

            }
        }
    }
}
