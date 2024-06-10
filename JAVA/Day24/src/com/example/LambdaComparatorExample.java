package com.example;

import java.util.*;

public class LambdaComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sort by age using a lambda expression
        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Print the sorted list
        people.forEach(System.out::println);
    }
}
