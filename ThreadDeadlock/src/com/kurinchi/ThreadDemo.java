package com.kurinchi;

import sun.font.TrueTypeFont;

public class ThreadDemo {

    public Integer lock1 = 5;
    public Integer lock2 = 6;

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("Locked lock2: " + lock2 + " by :" + Thread.currentThread().getName());
                    }
                }
            }
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (lock2) {
                    synchronized (lock1) {
                        System.out.println("Locked lock1: " + lock1 + " by :" + Thread.currentThread().getName());
                    }
                }
            }
        }
    });

    public static void ThreadDemo(String[] args) {

        ThreadDemo threaddemo = new ThreadDemo();
        threaddemo.t1.start();;
        threaddemo.t2.start();
    }
}
