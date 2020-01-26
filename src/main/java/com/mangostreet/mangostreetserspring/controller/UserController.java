package com.mangostreet.mangostreetserspring.controller;

import com.mangostreet.mangostreetserspring.config.exception.AjaxResponse;
import com.mangostreet.mangostreetserspring.dao.UserRepository;
import com.mangostreet.mangostreetserspring.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse authLogin(@RequestParam String username,
                                  @RequestParam String password){

        UserDO u =new UserDO();
        u.setUserName(username);
        u.setPassword(password);
        Example<UserDO> example = Example.of(u);

        UserDO user = userRepository.findOne(example).orElse(null);

        if (user == null){

            UserDO uu =new UserDO();
            uu.setUserName(username);
            uu.setPassword(password);
            uu.setId(2);
            userRepository.save(uu);
            return AjaxResponse.success();
        } else {
            return AjaxResponse.success(user);
        }

    }
}
