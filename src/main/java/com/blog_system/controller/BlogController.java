package com.blog_system.controller;

import com.blog_system.constant.Constants;
import com.blog_system.model.BlogInfo;
import com.blog_system.service.BlogService;
import com.blog_system.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;


    @RequestMapping("/getList")
    public List<BlogInfo> getList(){
        return blogService.getList();

    }

    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogDetail(Integer blogId,HttpServletRequest request) {
        BlogInfo blogDetail = blogService.getBlogDetail(blogId);
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        //从token中获取登录用户ID
        Integer userId = JwtUtils.getIdByToken(token);

        if (userId != null && blogDetail.getUserId() == userId) {
            blogDetail.setLoginUser(true);
        }

        return blogDetail;
    }


    /**
     * 发布博客
     * @param
     * @return
     */

    @RequestMapping("add")
    public boolean add(@RequestBody BlogInfo blogInfo, HttpServletRequest request){
       log.info("发布博客");
       if(!StringUtils.hasLength(blogInfo.getTitle()) || !StringUtils.hasLength(blogInfo.getContent())){
           return false;
       }

       //获取登录用户
        // 获取token
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
       //从token中获取登录用户ID
        Integer userId = JwtUtils.getIdByToken(token);
        if(userId == null || userId <=0){
            return false;
        }
        blogInfo.setUserId(userId);
        return blogService.insertBlog(blogInfo);
    }

    /**
     * 更新博客
     *
     */
    @RequestMapping("update")
    public Boolean update(BlogInfo blogInfo){
        log.info("更新博客{}",blogInfo);
        if(blogInfo.getId() == null ||
        !StringUtils.hasLength(blogInfo.getTitle())
        || !StringUtils.hasLength(blogInfo.getContent())) {

            return false;
        }
       return blogService.update(blogInfo);
    }

    /**
     * 删除博客
     */
    @RequestMapping("delete")
    public Boolean delete(Integer blogId){
        log.info("删除博客");
        if(blogId <=0){
            return false;
        }
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(1);
       return blogService.update(blogInfo);
    }
}
