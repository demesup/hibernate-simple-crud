package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    static SessionFactory sessionFactory;
    static Session session;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }


    static Session session() {
        return sessionFactory.openSession();
    }

    public void save(Student student) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public void update(Student student) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.merge(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public Student getById(long id) {
        Student student = null;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            student = session.getReference(Student.class, id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> student = new ArrayList<>();

        Transaction transaction = null;
        try (Session session = session()){
            transaction = session.beginTransaction();

            student = session.getEntityManagerFactory().createEntityManager().createQuery("select s from Student s", Student.class).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
        return student;
    }

    public void delete(long id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.remove(getById(id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }
}
