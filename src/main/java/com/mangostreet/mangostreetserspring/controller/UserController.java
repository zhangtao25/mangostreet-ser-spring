package com.mangostreet.mangostreetserspring.controller;

import com.mangostreet.mangostreetserspring.entity.User;
import com.mangostreet.mangostreetserspring.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    Userrepository userrepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userrepository.findById(1).orElse(null);
        return user;
    }
}
