package com.mangostreet.mangostreetserspring.repository;

import com.mangostreet.mangostreetserspring.dataobject.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserinfoRepository extends JpaRepository<Userinfo, String> {

    @Query("select userinfo from Userinfo userinfo where userinfo.userId = ?1")
    public Userinfo findByUserId(String userId);
}
