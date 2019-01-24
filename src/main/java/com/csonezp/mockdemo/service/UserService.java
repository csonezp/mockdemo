package com.csonezp.mockdemo.service;


import com.csonezp.mockdemo.entity.User;

public interface UserService {
    User findUserById(Long id);
    User addUser(String name);
}
