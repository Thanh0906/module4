package com.codegym.service;

import com.codegym.module.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
