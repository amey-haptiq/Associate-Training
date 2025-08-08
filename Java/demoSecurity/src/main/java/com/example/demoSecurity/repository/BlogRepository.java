package com.example.demoSecurity.repository;

import com.example.demoSecurity.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
