package com.exospher3.restapitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exospher3.restapitest.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
