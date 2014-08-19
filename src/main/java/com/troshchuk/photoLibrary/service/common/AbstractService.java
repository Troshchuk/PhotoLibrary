package com.troshchuk.photoLibrary.service.common;

import com.troshchuk.photoLibrary.repository.common.Operations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  19.08.14.
 */

@Transactional
public abstract class AbstractService<T, PK extends Serializable>
        implements Operations<T, PK> {

    @Override
    public PK create(T newInstance) {
        return getDao().create(newInstance);
    }

    @Override
    public T read(PK id) {
        return getDao().read(id);
    }

    @Override
    public void update(T transientObject) {
        getDao().update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        getDao().delete(persistentObject);
    }

    protected abstract Operations<T, PK> getDao();
}
