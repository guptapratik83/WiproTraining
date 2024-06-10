package com.example;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Create a Person instance
            Person person = new Person();

            // Get the Class object
            Class<?> personClass = person.getClass();

            // Inspect methods
            System.out.println("Methods:");
            Method[] methods = personClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            // Inspect fields
            System.out.println("\nFields:");
            Field[] fields = personClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Inspect constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = personClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Modify the access level of a private field and set its value
            Field privateField = personClass.getDeclaredField("name");
            privateField.setAccessible(true);
            privateField.set(person, "Jane Doe");

            // Verify the change
            System.out.println("\nModified name field value: " + person.getName());

            // Invoke a private method
            Method privateMethod = personClass.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
