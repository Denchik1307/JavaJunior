package homework_three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class PersonManager {
    @Autowired
    private JpaRepository<Person,Long> jpaRepository;

    // Метод для добавления нового Person
    public Person addPerson(Person person) {
        return jpaRepository.save(person);
    }

    // Метод для обновления Person
    public Person updatePerson(Long id, Person personDetails) {
        Optional<Person> optionalPerson = jpaRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(personDetails.getName());
            person.setAge(personDetails.getAge());
            return jpaRepository.save(person);
        } else {
            return null;
        }
    }

    // Метод для удаления Person
    public void deletePerson(Long id) {
        jpaRepository.deleteById(id);
    }

    // Метод для получения всех Person
    public List<Person> getAllPersons() {
        return jpaRepository.findAll();
    }

    // Метод для получения Person по id
    public Optional<Person> getPersonById(Long id) {
        return jpaRepository.findById(id);
    }
}
