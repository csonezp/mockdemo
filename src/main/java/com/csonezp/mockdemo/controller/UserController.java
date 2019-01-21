// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.controller;

import com.csonezp.mockdemo.entity.User;
import com.csonezp.mockdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangpeng34
 * Created on 2019/1/18 下午9:19
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user")
    public Object register(String name) {
        return userService.addUser(name);
    }

    @GetMapping(value = "/user/{userId}")
    public Object getUserInfo(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        if (user != null) {
            return user;
        }
        return "fail";

    }

    @PostMapping(value = "/user/login")
    public Object login(Long id, String pwd) {
        User user =  userService.findUserById(id);
        if(user!=null){
            return user;
        }
        return "fail";
    }
}