package homework_three;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "person.json";
        Person person1 = new Person("Alice", 30);

        // Сериализация
       person1.serialize(filename);

        // Десериализация
        Person deserializedPerson = Person.deserialize(filename);
        System.out.println("Deserialized person: " + deserializedPerson);
    }
}
