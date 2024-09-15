package homework_four;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Создание сессии Hibernate

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        try (factory; Session session = factory.openSession()) {
            // Открытие транзакции
            session.beginTransaction();

            // Создание объектов Person
            Person person1 = new Person("Alice", 30);
            Person person2 = new Person("Bob", 25);

            // Сохранение объектов в базе данных
            session.save(person1);
            session.save(person2);

            // Завершение транзакции
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}