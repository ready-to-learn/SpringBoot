package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.entity.UserEntity;
import com.example.model.User;

@Component
public interface UserRepository extends JpaRepository<UserEntity, String>{
    
   
}
