package com.example.repository;

import org.springframework.stereotype.Component;

import com.example.model.User;

@Component
public class UserRepository {
    
    public String registerUser(User user)
    {
        return "UserRespository.REGISTRATION_SUCCESS";
    }
}
