package main.repository;

import main.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstName(String firstName);
    List<Student> findAllByLastName(String lastName);
    List<Student> findAllByMiddleName(String middleName);}

