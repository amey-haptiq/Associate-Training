package com.example.demoTesting.controller;

import com.example.demoTesting.model.Blog;
import com.example.demoTesting.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BlogController.class)
public class BlogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    @Autowired
    private ObjectMapper objectMapper;

    private Blog blog;

    @BeforeEach
    public void setup() {
        blog = new Blog();
        blog.setId(1L);
        blog.setTitle("Test Blog");
        blog.setContent("Test Content");
    }

    @Test
    void testCreateBlog() throws Exception {
        Mockito.when(blogService.saveBlog(any(Blog.class))).thenReturn(blog);

        mockMvc.perform(post("/api/blogs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(blog)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(blog.getId()))
                .andExpect(jsonPath("$.title").value(blog.getTitle()))
                .andExpect(jsonPath("$.content").value(blog.getContent()));
    }

    @Test
    void testGetAllBlogs() throws Exception {
        List<Blog> blogList = Arrays.asList(blog);
        Mockito.when(blogService.getAllBlogs()).thenReturn(blogList);

        mockMvc.perform(get("/api/blogs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(blogList.size()))
                .andExpect(jsonPath("$[0].id").value(blog.getId()));
    }

    @Test
    void testGetBlogById_found() throws Exception {
        Mockito.when(blogService.getBlogById(1L)).thenReturn(Optional.of(blog));

        mockMvc.perform(get("/api/blogs/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(blog.getId()))
                .andExpect(jsonPath("$.title").value(blog.getTitle()));
    }



    @Test
    void testDeleteBlog() throws Exception {
        mockMvc.perform(delete("/api/blogs/1"))
                .andExpect(status().isNoContent());

        Mockito.verify(blogService).deleteBlog(1L);
    }
}
