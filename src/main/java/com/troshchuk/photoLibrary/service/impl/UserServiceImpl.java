package com.troshchuk.photoLibrary.service.impl;

import com.troshchuk.photoLibrary.domain.User;
import com.troshchuk.photoLibrary.repository.UserRepository;
import com.troshchuk.photoLibrary.repository.common.Operations;
import com.troshchuk.photoLibrary.service.UserService;
import com.troshchuk.photoLibrary.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  19.08.14.
 */

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService{
//    @Autowired
    private UserRepository repository;

    @Override
    protected Operations<User, Long> getDao() {
        return repository;
    }
}
