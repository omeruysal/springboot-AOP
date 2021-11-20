package com.example.springaopexample.service;

import com.example.springaopexample.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService2 {

    public User getUser(Long id, String name){

        return new User(id, name);
    }
}
