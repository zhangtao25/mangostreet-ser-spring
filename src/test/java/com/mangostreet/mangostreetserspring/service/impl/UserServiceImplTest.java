package com.mangostreet.mangostreetserspring.service.impl;

import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.dto.TokenDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findOne() throws Exception {
        User user = userService.findOne("ztzt");
        Assert.assertEquals("ztzt", user.getUserId());
    }

    @Test
    public void findByUserPhoneAndPwd() throws Exception {
        TokenDTO tokenDTO = userService.findByUserPhoneAndPwd("18158899797","password");
    }
}