// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author zhangpeng34
 * Created on 2019/1/24 下午2:33
 **/
@Service
public class DemoService {
    public String fun1(Integer x, Integer y, Integer z) {
        String res = null;
        if (x < 50 && y < 50) {
            if (z < 50) {
                res = "A";
            } else {
                res = "B";
            }
        } else {
            if (z < 50) {
                res = "C";
            }
        }
        return res;
    }

    public Integer fun2(Boolean a, Boolean b, Boolean c, Boolean d) {
        Integer res = 0;

        if (a && b) {
            res += 1;
        }
        if (c || d) {
            res += 2;
        }

        return res;
    }

    public Integer fun3(Integer a, Integer b, Integer x) {

        if (a > 1 && b == 0) {
            x += a;
        }
        if (a == 2 || x > 1) {
            x += 1;
        }
        return x;
    }

    public Integer fun4(Integer a, Integer b, Integer x) {

        if (a > 1 || b == 0) {
            x += a;
        }
        if (a == 2 || x > 1) {
            x += 1;
        }
        return x;
    }

}