// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhangpeng34
 * Created on 2019/1/18 下午9:08
 **/
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}