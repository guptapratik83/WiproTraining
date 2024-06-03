package com.example.threadlifecycle;

public class ThreadLifecycleExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle tl = new ThreadLifecycle();
        Thread thread = new Thread(tl);

        // State: NEW
        System.out.println("Thread state after creation: " + thread.getState());

        thread.start();
        // State: RUNNABLE
        System.out.println("Thread state after start(): " + thread.getState());

        Thread.sleep(500);
        // State: TIMED_WAITING (while sleeping)
        System.out.println("Thread state while sleeping: " + thread.getState());

        synchronized (tl) {
            tl.notify(); // Wake the thread from wait()
        }

        thread.join();
        // State: TERMINATED
        System.out.println("Thread state after completion: " + thread.getState());
    }
}

class ThreadLifecycle implements Runnable {

    @Override
    public void run() {
        try {
            // State: TIMED_WAITING
            Thread.sleep(1000);

            synchronized (this) {
                // State: WAITING
                wait();
            }

            // State: BLOCKED (if another thread holds the lock)
            synchronized (this) {
                // Code block to simulate BLOCKED state
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
