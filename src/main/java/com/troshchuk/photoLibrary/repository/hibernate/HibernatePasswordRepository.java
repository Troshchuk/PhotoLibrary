package com.troshchuk.photoLibrary.repository.hibernate;

import com.troshchuk.photoLibrary.domain.Password;
import com.troshchuk.photoLibrary.domain.User;
import com.troshchuk.photoLibrary.repository.PasswordRepository;
import com.troshchuk.photoLibrary.repository.UserRepository;
import com.troshchuk.photoLibrary.repository.common.GenericRepositoryHibernateImpl;
import org.springframework.stereotype.Repository;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */

@Repository
public class HibernatePasswordRepository
        extends GenericRepositoryHibernateImpl<Password, Long>
        implements PasswordRepository {
    public HibernatePasswordRepository() {
        setType(Password.class);
    }
}
