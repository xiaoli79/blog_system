package com.blog_system.service;


import com.blog_system.mapper.BlogMapper;
import com.blog_system.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;


    public List<BlogInfo> getList() {
       return  blogMapper.selectAll();
    }

    public BlogInfo getBlogDetail(Integer id) {
        return blogMapper.selectById(id);
    }

    public boolean insertBlog(BlogInfo blogInfo) {
        Integer result = blogMapper.insertBlog(blogInfo);
        if(result == 1){
            return true;
        }
        return false;
    }

    public Boolean update(BlogInfo blogInfo) {
        Integer result = blogMapper.updateBlog(blogInfo);
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }
}
