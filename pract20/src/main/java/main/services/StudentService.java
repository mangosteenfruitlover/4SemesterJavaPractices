package main.services;

import lombok.extern.slf4j.Slf4j;
import main.model.Student;
import main.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student getById(Long id) {
        log.info("Get student by id {}", id);
        return repository.findById(id).get();
    }

    public List<Student> getAll() {
        log.info("Get all students");
        // Delay simulation (for Spring AOP)
        try {
            Thread.sleep((long) (1000 + Math.random()*1440));
        } catch (InterruptedException ignored) { }

        return repository.findAll();
    }

    public List<Student> getAllSortedBy(String field) {
        log.info("Get all students sorted by field {}", field);
        return repository.findAll(Sort.by(field));
    }

    public void save(Student value) {
        log.info("Save student {}", value);
        repository.save(value);
    }

    public void delete(long id) {
        log.info("Delete student with id {}", id);
        repository.deleteById(id);
    }

    public List<Student> findAllByFirstName(String name) {
        log.info("Find all students by firstName with value {}", name);
        return repository.findAllByFirstName(name);
    }

    public List<Student> findAllByMiddleName(String name) {
        log.info("Find all students by middleName with value {}", name);
        return repository.findAllByMiddleName(name);
    }

    public List<Student> findAllByLastName(String name) {
        log.info("Find all students by lastName with value {}", name);
        return repository.findAllByLastName(name);
    }
}
