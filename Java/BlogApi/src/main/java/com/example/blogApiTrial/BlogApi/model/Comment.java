package com.example.blogApiTrial.BlogApi.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String comment;
    @ManyToOne
    @JoinColumn(name="userId",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="id",nullable = false)
    private Blog blog;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    public String getComment(){
        return comment;
    }
    public void SetComment(String comment){
        this.comment=comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
