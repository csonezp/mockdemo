// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.service;

import com.csonezp.mockdemo.dao.UserDao;
import com.csonezp.mockdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author zhangpeng34
 * Created on 2019/1/18 下午9:15
**/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User findUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }


    @Override
    public User addUser(String name) {
        if(StringUtils.isEmpty(name)){
            return null;
        }
        User user = new User();
        user.setName(name);
        return userDao.save(user);
    }
}