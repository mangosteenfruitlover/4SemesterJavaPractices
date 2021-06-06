package main.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class DBService<E> {
    protected Session session;
    protected Class<E> clazz;
    protected String className;

    public DBService(Class<E> studentClass) {
        this.clazz = studentClass;
        this.className = clazz.getSimpleName();
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

    public void saveOrUpdate(E entity) {
        execute(() -> session.saveOrUpdate(entity));
        session.clear();
    }

    public void delete(E entity) {
        execute(() -> session.delete(entity));
        session.clear();
    }

    public List<E> getAll() {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select e from " + className + " e", clazz);
        transaction.commit();
        return ((List<E>) query.getResultList());
    }

    public E getById(Long id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + className + " e where id=:id", clazz)
                .setParameter("id", id);
        transaction.commit();
        return (E) query.getSingleResult();
    }
}