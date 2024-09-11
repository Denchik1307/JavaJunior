package homework_three;

import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.*;

public class Person implements Serializable {
    private Long id;
    private String name;
    private int age;

    public Person(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // region getters & setters
    // Геттеры и сеттеры
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

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + "'" + ", age=" + age + "}";
    }


//endregion

    // region serialize methods
    // Сериализация объекта в файл
    public void serialize(String filename) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        XmlMapper xmlMapper = new XmlMapper();
        JsonMapper jsonMapper = new JsonMapper();
        try {
//            if (filename.endsWith(".xml")) xmlMapper.writeValue(new File(filename), Person.class);
//            if (filename.endsWith(".bin")) objectMapper.writeValue(new File(filename), Person.class);
            if (filename.endsWith(".json")) jsonMapper.writeValue(new File(filename), this);
        } catch (IOException exception) {
            System.out.println("Err serialize");
            exception.printStackTrace();
        }
    }

    // Десериализация объекта из файла
    public static Person deserialize(String filename) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        XmlMapper xmlMapper = new XmlMapper();
        JsonMapper jsonMapper = new JsonMapper();
        try {
//            if (filename.endsWith(".xml")) return xmlMapper.readValue(new File(filename), Person.class);
//            if (filename.endsWith(".bin")) return objectMapper.readValue(new File(filename), Person.class);
            if (filename.endsWith(".json")) return jsonMapper.readValue(new File(filename), Person.class);
        } catch (IOException exception) {
            System.out.println("Err deserialize");
            exception.printStackTrace();
        }
        return null;
    }
    // endregion
}
