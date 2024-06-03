package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a fixed-size thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit multiple tasks to the executor
        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                performComplexCalculation(taskNumber);
            });
        }

        // Shutdown the executor
        executor.shutdown();
        try {
            // Wait for all tasks to complete
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static void performComplexCalculation(int taskNumber) {
        System.out.println("Task " + taskNumber + " is starting.");

        // Simulate complex calculation or I/O operation
        try {
            Thread.sleep(2000);  // Simulate time-consuming task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Task " + taskNumber + " is completed.");
    }
}
