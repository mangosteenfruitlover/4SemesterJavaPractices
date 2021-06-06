package main.services;

import main.model.Student;
import main.model.University;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UniversityService extends DBService<University> {
    private final SessionFactory sessionFactory;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    void closeSession() {
        session.close();
    }

    public UniversityService(SessionFactory sessionFactory) {
        super(University.class);
        this.sessionFactory = sessionFactory;
    }

    public List<Student> getStudentsByUniversityName(Long id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from University where id =:id", University.class)
                .setParameter("id", id);
        return ((University) query.getSingleResult()).getStudents();
    }
}
