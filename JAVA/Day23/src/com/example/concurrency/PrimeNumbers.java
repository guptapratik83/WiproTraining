package com.example.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {

    public static void main(String[] args) {
        int maxNumber = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Calculate primes in parallel
        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            int start = (i - 1) * (maxNumber / 4) + 1;
            int end = i * (maxNumber / 4);
            futures.add(CompletableFuture.supplyAsync(() -> findPrimes(start, end), executor));
        }

        // Combine results
        CompletableFuture<List<Integer>> allPrimesFuture = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        ).thenApply(v -> futures.stream()
                .flatMap(future -> future.join().stream())
                .collect(Collectors.toList()));

        // Write results to a file
        allPrimesFuture.thenAcceptAsync(primes -> {
            try {
                Files.write(Paths.get("primes.txt"), primes.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList()));
                System.out.println("Primes written to file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, executor).join();

        // Shutdown the executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Integer> findPrimes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(PrimeNumbers::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
