package homework_three;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(1L,"Amica", 32);

        person.serialize("person.json");
        System.out.println(Person.deserialize("person.json"));
    }
}
