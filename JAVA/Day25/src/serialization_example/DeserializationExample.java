package serialization_example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Person recoveredPerson = (Person) in.readObject();
            System.out.println("Deserialized Person: " + recoveredPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
