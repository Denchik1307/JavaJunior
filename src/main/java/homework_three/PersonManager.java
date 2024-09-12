package homework_three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

public class PersonManager {
    @Autowired
    private JpaRepository<Person, Long> jpaRepository;

    // Метод для добавления нового Person
    public void addPerson(Person person) {
        jpaRepository.save(person);
    }

    // Метод для обновления Person
    public boolean updateNameByID(Long id, String newName) {
        Person findPerson = jpaRepository.getReferenceById(id);
        if (Objects.equals(findPerson.getId(), id)) {
            findPerson.setName(newName);
            jpaRepository.save(findPerson);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateSurnameByID(Long id, String newSurname) {
        Person findPerson = jpaRepository.getReferenceById(id);
        if (Objects.equals(findPerson.getId(), id)) {
            findPerson.setName(newSurname);
            jpaRepository.save(findPerson);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateAgeByID(Long id, int newAge) {
        Person findPerson = jpaRepository.getReferenceById(id);
        if (Objects.equals(findPerson.getId(), id)) {
            findPerson.setAge(newAge);
            jpaRepository.save(findPerson);
            return true;
        } else {
            return false;
        }
    }

    // Метод для удаления Person
    public void deletePerson(Long id) {
        jpaRepository.deleteById(id);
    }

    // Метод для получения Person по id
    public Person getPersonByID(Long id) {
        return jpaRepository.getReferenceById(id);
    }

    // Метод для получения всех Person
    public List<Person> getPersonsList() {
        return jpaRepository.findAll();
    }
}
