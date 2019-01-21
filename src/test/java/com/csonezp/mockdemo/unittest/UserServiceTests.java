// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.unittest;

import com.csonezp.mockdemo.dao.UserDao;
import com.csonezp.mockdemo.entity.User;
import com.csonezp.mockdemo.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author zhangpeng34
 * Created on 2019/1/21 下午2:03
 *
 * 单元测试，测试的目的是对木表层java代码逻辑进行测试。
 * 单纯的逻辑测试，不应该加载外部依赖，所有的外部依赖应该mock掉，只关注本身逻辑。
 * 例如，需要测试service层时，所依赖的dao等，应提前mock掉，设置好测试需要的输入和输出即可。
 * dao层的逻辑应由dao层的测试保证，service层默认dao层是正确的。
**/
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
    //mock注解创建一个被mock的实例
    @Mock
    UserDao userDao;


    //InjectMocks代表创建一个实例，其他带mock注解的示例将被注入到该实例用。
    //可以用该注解创建要被测试的实例，将实例所需的依赖用mock注解创建，即可mock掉依赖
    @InjectMocks
    UserServiceImpl UserServiceImpl;


    String addUserName = "testAddUser";

    /**
     * 初始化时设置一些需要mock的方法和返回值
     * 这里的设置表示碰到userDao的save方法，且参数为任一User类的实例时，返回提前预设的值
     */
    @Before
    public void init(){
        User user =new User();
        user.setId(1L);
        user.setName(addUserName);
        Mockito.when(userDao.save(any(User.class)))
                .thenReturn(user);
    }
    //正向流程
    @Test
    public void testAddUser(){
        User user = UserServiceImpl.addUser(addUserName);
        Assert.assertEquals(addUserName,user.getName());
        Assert.assertEquals(1L,user.getId().longValue());
    }
    //异常分支，name为null
    @Test
    public void testAddUserNull(){
        User user = UserServiceImpl.addUser(null);
        Assert.assertEquals(null,user);
    }
    //将各个分支都写出test和assert
    //............
}