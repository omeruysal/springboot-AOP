package com.example.springaopexample.controller;

import com.example.springaopexample.model.User;
import com.example.springaopexample.service.UserService1;
import com.example.springaopexample.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService1 userService1;
    @Autowired
    private UserService2 userService2;

    @GetMapping("/")
    public String success(){

        return "success";
    }

    @GetMapping("fromBoth/{id}/{name}")
    public List<User> getUsersFromBoth(@PathVariable("id")  Long id, @PathVariable("name") String name){
        User user1 = userService1.getUser(id,name);
        User user2 = userService2.getUser(id,name);

        return Arrays.asList(new User[] {user1,user2});
    }

    @GetMapping("from1/{id}/{name}")
    public User getUserFromUserService1(@PathVariable("id")  Long id,@PathVariable("name") String name){
        User user1 = userService1.getUser(id,name);

        return user1;
    }

    @GetMapping("from2/{id}/{name}")
    public User getUserFromUserService2(@PathVariable("id")  Long id,@PathVariable("name") String name){
        User user2 = userService2.getUser(id,name);

        return user2;
    }
}
