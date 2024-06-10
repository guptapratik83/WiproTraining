package serialization_example;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", email=" + email + "]";
    }
}
