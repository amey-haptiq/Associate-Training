package com.example.demoSecurity.controller;

import com.example.demoSecurity.model.Blog;
import com.example.demoSecurity.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/allposts")
    public List<Blog> getAllPosts(){
        return blogService.getAllPosts();
    }


    @PostMapping("/addposts")
    public Optional<Blog> addPosts(@RequestBody Blog blog){
        return blogService.addPosts( blog);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updatePost(@PathVariable Integer id,@RequestBody Blog blog){
         blogService.updatePost(id,blog);
         return ResponseEntity.ok(blog);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Integer id){
        blogService.deletePost(id);
        return "successfully deleted post where id:"+id;
    }

}
