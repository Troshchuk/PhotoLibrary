package com.troshchuk.photoLibrary.repository.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */
public class GenericRepositoryHibernateImpl<T, PK extends Serializable>
        implements GenericRepository<T, PK> {
    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PK create(T newInstance) {
        return (PK) getCurrentSession().save(newInstance);
    }

    @Override
    public T read(PK id) {
        return (T) getCurrentSession().get(type, id);
    }

    @Override
    public void update(T transientObject) {
        getCurrentSession().update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        getCurrentSession().delete(persistentObject);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
