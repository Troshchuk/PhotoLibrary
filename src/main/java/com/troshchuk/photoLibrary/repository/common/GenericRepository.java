package com.troshchuk.photoLibrary.repository.common;

import java.io.Serializable;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */
public interface GenericRepository<T, PK extends Serializable>
        extends Operations<T, PK> {
}
