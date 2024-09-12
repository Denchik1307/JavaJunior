package homework_three;

public class Main {
    public static void main(String[] args) {

        Person person = new Person(1l, "Nik1", "Pupkin", 32);
        String fileName = "person.json";

        person.serialize(fileName);
        System.out.println(Person.deserialize(fileName));

    }
}
