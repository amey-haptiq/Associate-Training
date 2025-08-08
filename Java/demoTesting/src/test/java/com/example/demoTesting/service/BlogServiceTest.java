package com.example.demoTesting.service;

import com.example.demoTesting.model.Blog;
import com.example.demoTesting.repository.BlogRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    @Test
    void testSaveBlog() {
        Blog blog = new Blog(1L, "Test Title", "Test Content", "Author");

        Mockito.when(blogRepository.save(blog)).thenReturn(blog);

        Blog saved = blogService.saveBlog(blog);

        assertNotNull(saved);
        assertEquals("Test Title", saved.getTitle());

    }

    @Test
    void testGetAllBlogs() {
        List<Blog> blogs = Arrays.asList(
                new Blog(1L, "Title1", "Content1", "Author1"),
                new Blog(2L, "Title2", "Content2", "Author2")
        );

        Mockito.when(blogRepository.findAll()).thenReturn(blogs);

        List<Blog> result = blogService.getAllBlogs();

        assertEquals(2, result.size());
    }

    @Test
    void testGetBlogById() {
        Blog blog = new Blog(1L, "Title", "Content", "Author");

        Mockito.when(blogRepository.findById(1L)).thenReturn(Optional.of(blog));

        Optional<Blog> result = blogService.getBlogById(1L);

        assertTrue(result.isPresent());
        assertEquals("Title", result.get().getTitle());
    }

    @Test
    void testDeleteBlog() {
        Long id = 1L;

        blogService.deleteBlog(id);

        Mockito.verify(blogRepository).deleteById(id);
    }
}
