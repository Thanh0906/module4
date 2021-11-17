package com.codegym.service;

import com.codegym.model.User;
import com.codegym.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;
//UserDetailsService có sẵn của Spring
// (lớp chứa phương thức load tất cả user từ trong database bằng username)
public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}