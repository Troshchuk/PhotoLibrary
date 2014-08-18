package com.troshchuk.photoLibrary.repository.common;

import java.io.Serializable;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */
public interface GenericRepository<T, PK extends Serializable> {
    /** Persist the newInstance object into database */
    PK create(T newInstance);

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(PK id);

    /** Save changes made to a persistent object.  */
    void update(T transientObject);

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject);
}
