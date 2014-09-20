package com.troshchuk.photoLibrary.service;

import com.troshchuk.photoLibrary.domain.User;
import com.troshchuk.photoLibrary.repository.common.Operations;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  19.08.14.
 */
public interface UserService extends Operations<User, Long> {
    public Long create(User user, String password);
    public User read(String email, String password);
}
