package homework_three;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Person implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private int age;

    public Person() {
        super();
    }

    public Person(Long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // region getters & setters & toString
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

//endregion

    // region serialize methods
    // Сериализация объекта в файл

    /**
     * @param filename ony .bin or .json
     */
    public void serialize(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonMapper jsonMapper = new JsonMapper();
        try {
            if (filename.endsWith(".bin")) objectMapper.writeValue(new File(filename), this);
            if (filename.endsWith(".json")) jsonMapper.writeValue(new File(filename), this);
        } catch (IOException exception) {
            System.out.println("Err serialize");
            exception.printStackTrace();
        }
    }

    // Десериализация объекта из файла
    /**
     * @param filename ony .bin or .json
     */
    public static Person deserialize(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonMapper jsonMapper = new JsonMapper();
        try {
            if (filename.endsWith(".bin")) return objectMapper.readValue(new File(filename), Person.class);
            if (filename.endsWith(".json")) return jsonMapper.readValue(new File(filename), Person.class);
        } catch (IOException exception) {
            System.out.println("Err deserialize");
            exception.printStackTrace();
        }
        return null;
    }
    // endregion
}
