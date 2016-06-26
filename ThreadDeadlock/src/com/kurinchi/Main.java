package com.kurinchi;

import sun.font.TrueTypeFont;

public class Main {

    public static Integer lock1 = 5;//new Integer(5);
    public static Integer lock2 = 6;//new Integer(6);

    public static class Thread1 implements Runnable {

        public void run() {

            while (true) {
                synchronized (lock1) {

                    synchronized (lock2) {

                        System.out.println("Locked lock2: " + lock2 + " by :" + Thread.currentThread().getName());

                    }
                }
            }
        }
    }

    public static class Thread2 implements Runnable {

        public void run() {

            while (true) {
                synchronized (lock2) {

                    synchronized (lock1) {

                        System.out.println("Locked lock1: " + lock1 + " by :" + Thread.currentThread().getName());
                    }

                }

            }
        }

    }


    public static void main(String[] args) {

        Thread t1 = new Thread(new Main.Thread1());
        Thread t2 = new Thread(new Main.Thread2());
        t1.start();
        t2.start();
        //t1.run();
        //t2.run();
    }
}
