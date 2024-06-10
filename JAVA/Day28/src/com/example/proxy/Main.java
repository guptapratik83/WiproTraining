package com.example.proxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating a sensitive object with a secret key
        String secretKey = "super_secret_key_123";
        SensitiveObject sensitiveObject = new SensitiveObject(secretKey);

        // Creating a proxy with the correct password
        String correctPassword = "my_secure_password";
        Proxy proxy = new Proxy(sensitiveObject, correctPassword);

        // Trying to access the secret key with the correct password
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password to access the secret key: ");
        String providedPassword = scanner.nextLine();

        try {
            String secret = proxy.accessSecretKey(providedPassword);
            System.out.println("Access granted! The secret key is: " + secret);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
