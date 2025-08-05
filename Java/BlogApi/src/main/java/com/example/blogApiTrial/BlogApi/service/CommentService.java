package com.example.blogApiTrial.BlogApi.service;

import com.example.blogApiTrial.BlogApi.model.Blog;
import com.example.blogApiTrial.BlogApi.model.Comment;
import com.example.blogApiTrial.BlogApi.model.User;
import com.example.blogApiTrial.BlogApi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    public void addComment(Comment comment,String uname,String title){
      User user=userService.getByName(uname);
      if(user==null){
          System.out.println("User is null");
          return;
      }
        Blog blog =blogService.getByTitle(title);
      if(blog==null){
          System.out.println("Blog is null");
          return;
      }
      comment.setBlog(blog);
      comment.setUser(user);

      commentRepository.save(comment);


    }
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
