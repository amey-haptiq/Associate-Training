package com.example.blogApiTrial.BlogApi.controller;

import com.example.blogApiTrial.BlogApi.model.Comment;
import com.example.blogApiTrial.BlogApi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService){
        this.commentService=commentService;
    }
    @PostMapping("/addcomment")
    public String addComment(@RequestBody Comment comment, @RequestParam String uname, @RequestParam String title){
        commentService.addComment(comment,uname,title);
        return "Success";
    }
    @GetMapping("/getallcomments")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }
}
