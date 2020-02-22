package com.mangostreet.mangostreetserspring.controller;

import com.mangostreet.mangostreetserspring.VO.ResultVO;
import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.dataobject.Userinfo;
import com.mangostreet.mangostreetserspring.dto.TokenDTO;
import com.mangostreet.mangostreetserspring.form.LoginForm;
import com.mangostreet.mangostreetserspring.service.UserService;
import com.mangostreet.mangostreetserspring.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import javax.xml.transform.Result;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public ResultVO detail (
            @RequestParam(value = "userPhone", required = false) String userPhone,
            @RequestParam(value = "userToken", required = false) String userToken){

        Userinfo userinfo = userService.findByUserPhoneAndUserToken(userPhone,userToken);
        return ResultVOUtil.success(userinfo);
    }

    @PostMapping("/login")
    public ResultVO login (@RequestBody LoginForm jsonParam){

        String userPhone = jsonParam.getUserPhone();
        String userPassword = jsonParam.getUserPassword();

        TokenDTO tokenDTO = userService.findByUserPhoneAndPwd(userPhone,userPassword);
        return ResultVOUtil.success(tokenDTO);
    }
}
