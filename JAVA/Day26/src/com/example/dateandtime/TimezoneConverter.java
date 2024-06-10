package com.example.dateandtime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

public class TimezoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Input the date-time
        System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeInput = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeInput, formatter);

        // Get the available time zones
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        
        // Input the source timezone
        String sourceTimezone;
        while (true) {
            System.out.println("Enter the source timezone (e.g., America/New_York): ");
            sourceTimezone = scanner.nextLine();
            if (availableZoneIds.contains(sourceTimezone)) {
                break;
            } else {
                System.out.println("Invalid time zone ID. Please enter a valid time zone.");
            }
        }
        ZoneId sourceZoneId = ZoneId.of(sourceTimezone);

        // Input the target timezone
        String targetTimezone;
        while (true) {
            System.out.println("Enter the target timezone (e.g., Europe/London): ");
            targetTimezone = scanner.nextLine();
            if (availableZoneIds.contains(targetTimezone)) {
                break;
            } else {
                System.out.println("Invalid time zone ID. Please enter a valid time zone.");
            }
        }
        ZoneId targetZoneId = ZoneId.of(targetTimezone);

        // Convert the time to the target timezone
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceZoneId);
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);

        // Output the result
        System.out.println("Time in " + targetTimezone + ": " + targetZonedDateTime.format(formatter));
    }
}
