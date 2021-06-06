package main.services;

import main.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class StudentService extends DBService<Student> {
    public StudentService(SessionFactory sessionFactory) {
        super(sessionFactory, Student.class);
    }
}
