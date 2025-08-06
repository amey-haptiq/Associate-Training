package com.example.blogApiTrial.BlogApi.controller;

import com.example.blogApiTrial.BlogApi.model.Blog;
import com.example.blogApiTrial.BlogApi.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    BlogService blogService;
    @Autowired
    public BlogController(BlogService blogService){
        this.blogService=blogService;
    }

    @GetMapping("/allposts")
    public List<Blog> allPosts(){
        return blogService.allPosts();
    }
    @GetMapping("/posts")
    public List<Blog> allBlogPosts(@RequestParam(defaultValue = "0",required = false) int page,@RequestParam(defaultValue = "5",required = false) int size){
        return blogService.allBlogPosts(page, size);
    }

    @PostMapping("/insertrecord")
    public String insertRecord(@RequestBody Blog blog){
        blogService.insertRecord(blog);
        return "success";
    }
    @GetMapping("/posts/{id}")
    public Optional<Blog> fetchById(@PathVariable Integer id){
        return blogService.fetchById(id);
    }

    @GetMapping("/postsby/")
    public ResponseEntity<List<Blog>> fetchByAuthor(@RequestParam String author, @RequestParam int pageNumber, @RequestParam int pageSize){
        return ResponseEntity.ok(blogService.fetchByAuthor(author, pageNumber,pageSize));

    }

    @PostMapping("writeblog")
    public String writeToBlog(@RequestBody Blog blog,@RequestParam String username){
        blogService.writeToBlog(blog,username);
        return "success";
    }

}
