package com.example.blogApiTrial.BlogApi.service;

import com.example.blogApiTrial.BlogApi.model.Blog;
import com.example.blogApiTrial.BlogApi.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    BlogRepository blogRepository;
    @Autowired
    public BlogService(BlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }

    public List<Blog> allBlogPosts(int page,int size){
        Pageable pageable=  PageRequest.of(page,size);
        Page<Blog> pageResult=blogRepository.findAll( pageable);
        return pageResult.getContent();
    }
    public void insertRecord(Blog blog){
        blogRepository.save(blog);

    }

    public Optional<Blog> fetchById(Integer id){
        return blogRepository.findById(id);
    }
    public List<Blog> fetchByAuthor(String author, int pageNumber, int pageSize){


        Pageable pageable=PageRequest.of(pageNumber, pageSize);
         return blogRepository.findByAuthor(author, pageable);




    }

    public List<Blog> allPosts(){
        return blogRepository.findAll();
    }
    public Blog getByTitle(String title){
        Blog blog=blogRepository.findByTitle(title);
        return blog;
    }
    public void writeToBlog(Blog blog,String username){
        blog.setAuthor(username);
        blogRepository.save(blog);
    }
}
