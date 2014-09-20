package com.troshchuk.photoLibrary.repository.hibernate;

import com.troshchuk.photoLibrary.domain.User;
import com.troshchuk.photoLibrary.repository.UserRepository;
import com.troshchuk.photoLibrary.repository.common.GenericRepositoryHibernateImpl;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */

@Repository
public class HibernateUserRepository
        extends GenericRepositoryHibernateImpl<User, Long>
        implements UserRepository {

    public HibernateUserRepository() {
        setType(User.class);
    }

    @Override
    public User readByEmail(String email) {
        List<User> list = getCurrentSession().createCriteria(User.class).add(
                Restrictions.eq("email", email)).list();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
