package com.example.blogApiTrial.BlogApi.service;

import com.example.blogApiTrial.BlogApi.model.User;
import com.example.blogApiTrial.BlogApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }

    public void insertUser(User user){
        userRepository.save(user);

    }

    public User getByName(String name){
        User user=userRepository.findByUserName(name);
        return user;
    }
}
