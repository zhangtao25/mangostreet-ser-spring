package com.mangostreet.mangostreetserspring.repository;

import com.mangostreet.mangostreetserspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User,Integer> {
}
