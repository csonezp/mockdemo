// Copyright (C) 2019 Meituan
// All rights reserved
package com.csonezp.mockdemo.unittest;

import com.csonezp.mockdemo.service.DemoService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangpeng34
 * Created on 2019/1/24 下午2:47
**/
@SuppressWarnings("Duplicates")
public class DemoServiceTest {
    DemoService demoService= new DemoService();

    /**
     * fun1 语句覆盖
     */
    @Test
    public void testFun1StatementCoverage(){
        //case 1
        Integer x=1,y=1,z=1;
        String res = demoService.fun1(x, y, z);
        Assert.assertEquals("A",res);

        //case 2
        x=1;y=1;z=100;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals("B",res);

        //case 3
        x=100;y=100;z=1;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals("C",res);
    }

    /**
     * fun1 判定覆盖
     */
    @Test
    public void testFun1DecisionCoverage(){
        //case 1
        Integer x=1,y=1,z=1;
        String res = demoService.fun1(x, y, z);
        Assert.assertEquals("A",res);

        //case 2
        x=1;y=1;z=100;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals("B",res);

        //case 3
        x=100;y=100;z=1;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals("C",res);

        //case 4
        x=100;y=100;z=100;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals(null,res);
    }

    /**
     * fun1 条件覆盖
     */
    @Test
    public void testFun1ConditionCoverage(){
        //case 1
        Integer x=1,y=100,z=1;
        String res = demoService.fun1(x, y, z);
        Assert.assertEquals("C",res);

        //case 2
        x=100;y=1;z=100;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals(null,res);

        //case 3
        x=1;y=1;z=1;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals("A",res);

        //case 4
        x=1;y=1;z=100;
        res = demoService.fun1(x,y,z);
        Assert.assertEquals("B",res);
    }


    /**
     * fun2 语句覆盖
     */
    @Test
    public void testFun2StatementCoverage(){
        //case 1
        Boolean a=true,b=true,c=true,d=true;
        int res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(3,res);
    }

    /**
     * fun2 语句覆盖
     */
    @Test
    public void testFun2DecisionCoverage(){
        //case 1
        Boolean a=true,b=true,c=true,d=false;
        int res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(3,res);

        //case 2
        a=true;b=false;c=false;d=false;
        res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(0,res);
    }

    /**
     * fun2 条件覆盖
     */
    @Test
    public void testFun2ConditionCoverage(){
        //case 1
        Boolean a=true,b=true,c=true,d=true;
        int res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(3,res);

        //case 2
        a=false;b=false;c=false;d=false;
        res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(0,res);
    }


    /**
     * fun2 路径覆盖
     */
    @Test
    public void testFun2PathCoverage(){
        //case 1
        Boolean a=true,b=true,c=true,d=true;
        int res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(3,res);

        //case 2
        a=false;b=false;c=false;d=false;
        res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(0,res);

        //case 3
        a=true;b=true;c=false;d=false;
        res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(1,res);

        //case 4
        a=false;b=false;c=true;d=true;
        res = demoService.fun2(a,b,c,d);
        Assert.assertEquals(2,res);
    }

    @Test
    public void testFun3StatementCoverage(){
        Integer res = demoService.fun3(2,0,3);
        Assert.assertEquals(6,res.intValue());
    }

    @Test
    public void testFun3DecisionCoverage(){
        Integer res = demoService.fun3(2,0,1);
        Assert.assertEquals(4,res.intValue());
        res = demoService.fun3(3,1,1);
        Assert.assertEquals(1,res.intValue());
    }

    @Test
    public void testFun3ConditionCoverage(){
        Integer res = demoService.fun3(2,0,3);
        Assert.assertEquals(6,res.intValue());
        res = demoService.fun3(0,1,0);
        Assert.assertEquals(0,res.intValue());
    }

    @Test
    public void testFun3PathCoverage(){
        Integer res = demoService.fun3(0,1,0);
        Assert.assertEquals(0,res.intValue());

        res = demoService.fun3(3,0,-3);
        Assert.assertEquals(0,res.intValue());
        res = demoService.fun3(2,1,3);
        Assert.assertEquals(4,res.intValue());

        res = demoService.fun3(2,0,3);
        Assert.assertEquals(6,res.intValue());

    }

}