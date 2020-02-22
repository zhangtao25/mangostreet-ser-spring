package com.mangostreet.mangostreetserspring.repository;

import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.dataobject.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

     @Query("select user from User user where user.userPhone = ?1 and user.userPassword = ?2")
     public User findByUserPhoneAndPwd(String userPhone,String userPassword);

     @Query("select user from User user where user.userPhone = ?1 and user.userToken = ?2")
     public User findByUserPhoneAndUserToken(String userPhone,String userToken);
}
