package com.mangostreet.mangostreetserspring.controller;

import com.mangostreet.mangostreetserspring.dao.UserRepository;
import com.mangostreet.mangostreetserspring.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public UserDO getUser(@PathVariable("id") Integer id){
        UserDO user = userRepository.findById(id).orElse(null);
        return user;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    @ResponseBody
    public UserDO addUser(@RequestParam String username,
                          @RequestParam String password){

        UserDO user = new UserDO();
        user.setId(1);
        user.setUserName(username);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }
}
