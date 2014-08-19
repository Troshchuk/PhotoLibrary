package com.troshchuk.photoLibrary.repository;

import com.troshchuk.photoLibrary.domain.User;
import com.troshchuk.photoLibrary.repository.common.GenericRepository;
import com.troshchuk.photoLibrary.repository.common.Operations;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */
public interface UserRepository extends Operations<User, Long> {
}
