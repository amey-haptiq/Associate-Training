package com.example.blogApiTrial.BlogApi.controller;

import com.example.blogApiTrial.BlogApi.model.User;
import com.example.blogApiTrial.BlogApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontroller {
    UserService userService;
    @Autowired
    public Usercontroller(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public List<User> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

    @PostMapping("/insertuser")
    public String addUser(@RequestBody User user){
        userService.insertUser(user);
        return "success";
    }




}
