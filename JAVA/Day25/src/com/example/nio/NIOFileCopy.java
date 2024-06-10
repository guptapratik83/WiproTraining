package com.example.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileCopy {
    public static void main(String[] args) {
        // Print working directory
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        // Use absolute paths
        String sourceFile = "C:\\Users\\Administrator\\Desktop\\24NAG0873-15\\Wipro Full stack Training\\JAVA\\";
        String destinationFile = "C:/path/to/destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile);
             FileChannel sourceChannel = fis.getChannel();
             FileChannel destinationChannel = fos.getChannel()) {

            // Create buffer with capacity of 1KB
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read data from the source file channel into the buffer
            while (sourceChannel.read(buffer) != -1) {
                // Flip the buffer to prepare for writing
                buffer.flip();

                // Write data from buffer to the destination file channel
                while (buffer.hasRemaining()) {
                    destinationChannel.write(buffer);
                }

                // Clear the buffer for next read
                buffer.clear();
            }

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
