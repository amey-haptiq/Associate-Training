package com.example.blogApiTrial.BlogApi.repository;

import com.example.blogApiTrial.BlogApi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
