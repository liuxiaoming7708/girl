package com.payease;

import com.payease.domain.Girl;
import com.payease.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * service 测试类
 * Created by liuxiaoming on 2017/11/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest{

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(13);
        Assert.assertEquals((Object) new Integer(20), girl.getAge());
    }

}
