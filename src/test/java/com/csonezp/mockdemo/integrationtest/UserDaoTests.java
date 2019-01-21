// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.integrationtest;

import com.csonezp.mockdemo.dao.UserDao;
import com.csonezp.mockdemo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangpeng34
 * Created on 2019/1/19 上午2:33
**/
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@ActiveProfiles("it")
public class UserDaoTests {

    @Autowired
    UserDao userDao;

    @Test
    public void testSaveAndFind(){
        User user = new User();
        user.setName("sadasd");
        userDao.save(user);
        user = userDao.findById(1L).get();
        Assert.assertEquals("sadasd",user.getName());
    }
}