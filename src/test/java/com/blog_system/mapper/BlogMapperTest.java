package com.blog_system.mapper;

import com.blog_system.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class BlogMapperTest {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    void selectAll() {
        blogMapper.selectAll();
    }

    @Test
    void selectById() {
        blogMapper.selectById(1);
    }

    @Test
    void updateBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(3);
        blogInfo.setContent("test");
        blogMapper.updateBlog(blogInfo);
    }

    @Test
    void insertBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("testtesttest");
        blogInfo.setContent("测试测试测试###");
        blogInfo.setUserId(1);
        blogMapper.insertBlog(blogInfo);
    }
}