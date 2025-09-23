package com.blog_system.service;


import com.blog_system.mapper.BlogMapper;
import com.blog_system.mapper.UserInfoMapper;
import com.blog_system.model.BlogInfo;
import com.blog_system.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogMapper blogMapper;;

    public UserInfo selectByName(String userName) {
        return userInfoMapper.selectByName(userName);
    }

    public UserInfo selectById(Integer userId) {
        return userInfoMapper.selectById(userId);
    }

    public UserInfo getAuthorId(Integer blogId) {
         BlogInfo blogInfo = blogMapper.selectById(blogId);
         if(blogInfo == null && blogInfo.getUserId() <=0){
             return null;
         }
//         根据用户ID，来获取用户信息
         return userInfoMapper.selectById(blogInfo.getUserId());
    }
}
