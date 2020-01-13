package com.mangostreet.mangostreetserspring.dao;

import com.mangostreet.mangostreetserspring.domain.UserDO;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserDO,Integer> {

}