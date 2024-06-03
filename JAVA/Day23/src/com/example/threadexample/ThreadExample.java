package com.example.threadexample;

public class ThreadExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter(), "Thread 1");
        Thread thread2 = new Thread(new NumberPrinter(), "Thread 2");

        thread1.start();
        thread2.start();
    }
}

class NumberPrinter implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}
