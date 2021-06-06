package main.services;

import lombok.extern.slf4j.Slf4j;
import main.model.Student;
import main.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository repository;
    private final EmailService emailService;

    public StudentService(StudentRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @Transactional(readOnly = true)
    public Student getById(Long id) {
        log.info("Get student by id {}", id);
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Student> getAll() {
        log.info("Get all students");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Student> getAllSortedBy(String field) {
        log.info("Get all students sorted by field {}", field);
        return repository.findAll(Sort.by(field));
    }

    @Transactional
    @Async
    public void save(Student value) {
        log.info("Save student {}", value);
        repository.save(value);
        emailService.send(value);
    }

    @Transactional
    @Async
    public void delete(long id) {
        log.info("Delete student with id {}", id);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Student> findAllByFirstName(String name) {
        log.info("Find all students by firstName with value {}", name);
        return repository.findAllByFirstName(name);
    }

    @Transactional(readOnly = true)
    public List<Student> findAllByMiddleName(String name) {
        log.info("Find all students by middleName with value {}", name);
        return repository.findAllByMiddleName(name);
    }

    @Transactional(readOnly = true)
    public List<Student> findAllByLastName(String name) {
        log.info("Find all students by lastName with value {}", name);
        return repository.findAllByLastName(name);
    }
}
