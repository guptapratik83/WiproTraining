package com.example;

import java.util.function.*;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        Person person = new Person("John", 30);

        // Predicate: Check if the person's age is greater than 20
        Predicate<Person> isAdult = p -> p.getAge() > 20;
        System.out.println("Is adult: " + isAdult.test(person));

        // Function: Get the person's name
        Function<Person, String> getName = Person::getName;
        System.out.println("Name: " + getName.apply(person));

        // Consumer: Set the person's name
        Consumer<Person> setName = p -> p.setName("Jane");
        setName.accept(person);
        System.out.println("Updated person: " + person);

        // Supplier: Create a new person
        Supplier<Person> personSupplier = () -> new Person("Alice", 25);
        Person newPerson = personSupplier.get();
        System.out.println("New person: " + newPerson);
    }
}
