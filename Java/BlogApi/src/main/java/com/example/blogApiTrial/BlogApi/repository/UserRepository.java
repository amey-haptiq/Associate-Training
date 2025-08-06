package com.example.blogApiTrial.BlogApi.repository;

import com.example.blogApiTrial.BlogApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
