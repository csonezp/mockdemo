// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.integrationtest;

import com.csonezp.mockdemo.dao.UserDao;
import com.csonezp.mockdemo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhangpeng34
 * Created on 2019/1/18 下午9:52
 * 集成测试的例子，controller层面
**/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("it")
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    UserDao userDao;

    Long userId;

    @Before
    public void init(){
        User user = new User();
        user.setName("111");
        userId = userDao.save(user).getId();
        System.out.println(userId);
    }

    /**
     * 测试/user/{userId}
     * @throws Exception
     */
    @Test
    public void testGetUser() throws Exception {
        //success
        this.mvc.perform(get("/user/"+userId)).andExpect(status().isOk())
                .andExpect(content().json("{ \"id\": "+userId+", \"name\": \"111\" }"));
        //fail
        this.mvc.perform(get("/user/"+(userId+100))).andExpect(status().isOk())
                .andExpect(content().string("fail"));
    }

    /**
     * 测试login
     * @throws Exception
     */
    @Test
    public void exampleTest2() throws Exception {
        //success
        this.mvc.perform(post("/user/login").param("id",userId.toString()).param("pwd","11"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ \"id\": "+userId+", \"name\": \"111\" }"));

        //fail
        this.mvc.perform(post("/user/login").param("id",userId.toString()+"11").param("pwd","11"))
                .andExpect(status().isOk())
                .andExpect(content().string("fail"));
    }
}