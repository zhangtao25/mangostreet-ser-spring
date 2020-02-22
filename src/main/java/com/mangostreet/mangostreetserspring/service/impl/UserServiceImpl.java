package com.mangostreet.mangostreetserspring.service.impl;

import com.mangostreet.mangostreetserspring.converter.User2TokenDTOConverter;
import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.dataobject.Userinfo;
import com.mangostreet.mangostreetserspring.dto.TokenDTO;
import com.mangostreet.mangostreetserspring.repository.UserRepository;
import com.mangostreet.mangostreetserspring.repository.UserinfoRepository;
import com.mangostreet.mangostreetserspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserinfoRepository userinfoRepository;

    public User findOne(String userId) {
        /*
         * 查不到返回null
         * .get 抛异常
         */
        return repository.findById(userId).orElse(null);
    }

    @Override
    public TokenDTO findByUserPhoneAndPwd(String userPhone, String userPassword) {
        User user = repository.findByUserPhoneAndPwd(userPhone,userPassword);
        TokenDTO tokenDTO = User2TokenDTOConverter.convert(user);
        return tokenDTO;
    }

    @Override
    public Userinfo findByUserPhoneAndUserToken(String userPhone, String userToken) {
        User user = repository.findByUserPhoneAndUserToken(userPhone,userToken);
//        User
        Userinfo userInfo = userinfoRepository.findByUserId(user.getUserId());
        return userInfo;
    }


    public User addUser(User user) {
        return repository.save(user);
    }

//    public User findByUserPhoneAndPwd(String userPhone,String userPassword) {
//        return repository.findByUserPhoneAndPwd(userPhone,userPassword);
//    }

}
