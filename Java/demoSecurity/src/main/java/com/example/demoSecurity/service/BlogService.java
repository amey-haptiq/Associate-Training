package com.example.demoSecurity.service;

import com.example.demoSecurity.model.Blog;
import com.example.demoSecurity.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllPosts(){
        return blogRepository.findAll();
    }


    public Optional<Blog> addPosts(Blog blog){
        return Optional.of(blogRepository.save(blog));
    }


    public void updatePost(Integer id,Blog blog){
        Optional<Blog> blog1=blogRepository.findById(id);
        Blog blog2=blog1.get();
        System.out.println(blog2);
        blog2.setContent(blog.getContent());
        blog2.setTitle(blog.getTitle());
        blogRepository.save(blog2);
        System.out.println(blog2.getBlogId());

    }

    public void deletePost(Integer id){
        blogRepository.deleteById(id);
    }
}
