package main.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public List<E> orderBy(String field) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(clazz);

        Root<E> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root)
                .orderBy(criteriaBuilder.asc(root.get(field)));

        Query<E> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<E> filter(String field, Object value) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(clazz);

        Root<E> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get(field), value));

        Query<E> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}