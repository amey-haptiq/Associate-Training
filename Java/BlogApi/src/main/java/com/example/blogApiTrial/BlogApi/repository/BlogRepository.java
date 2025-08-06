package com.example.blogApiTrial.BlogApi.repository;

import com.example.blogApiTrial.BlogApi.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findByAuthor(String author, Pageable pageable );
    Blog findByTitle(String title);
}
