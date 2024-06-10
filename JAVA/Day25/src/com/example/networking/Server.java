package com.example.networking;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

                    Operation operation = (Operation) inputStream.readObject();
                    int result = performOperation(operation);
                    outputStream.writeInt(result);
                    outputStream.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int performOperation(Operation operation) {
        int number1 = operation.getNumber1();
        int number2 = operation.getNumber2();
        String op = operation.getOperation();

        switch (op) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number2 != 0 ? number1 / number2 : 0; // handle divide by zero
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + op);
        }
    }
}
