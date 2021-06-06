package main.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class DBService<E> {
    @Autowired
    private final SessionFactory sessionFactory;

    protected Session session;
    protected Class<E> clazz;
    protected String className;

    public DBService(SessionFactory sessionFactory, Class<E> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    void closeSession() {
        session.close();
    }

    public void execute(Runnable runnable) {
        Transaction transaction = session.beginTransaction();
        try {
            runnable.run();
            transaction.commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            transaction.rollback();
        }
    }

    public void insert(E entity) {
        execute(() -> session.save(entity));
    }

    public void delete(E entity) {
        execute(() -> session.delete(entity));
    }

    public List<E> getAll() {
        return session.createQuery("select e from " + className + " e", clazz)
                .getResultList();
    }

    public E getById(Long id) {
        return session.createQuery("from " + className + " e where id=:id", clazz)
                .setParameter("id", id)
                .getSingleResult();
    }
}