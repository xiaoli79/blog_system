package com.blog_system.controller;


import com.blog_system.constant.Constants;
import com.blog_system.mapper.UserInfoMapper;
import com.blog_system.model.BlogInfo;
import com.blog_system.model.Result;
import com.blog_system.model.UserInfo;
import com.blog_system.service.BlogService;
import com.blog_system.service.UserService;
import com.blog_system.utils.JwtUtils;
import com.blog_system.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录
 * 登录是挺复杂的，但是只要写多了，就好了
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/login")
    public Result login(String userName, String password){
        log.info("用户登录，用户名：{}，密码：{}",userName,password);

        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return Result.fail("用户名或密码不能为空");
        }

//      从数据库中获取用户信息~~
        UserInfo userInfo = userService.selectByName(userName);


        if(userInfo == null){
            log.info("用户不存在");
            return Result.fail("用户不存在");
        }

        //验证密码~
        if(!SecurityUtils.verify(password, userInfo.getPassword())){
            return Result.fail("密码错误");
        }


        Map<String,Object> claim = new HashMap<>();
        claim.put("id",userInfo.getId());
        claim.put("userName",userInfo.getUserName());
        String token = JwtUtils.genJwtToken(claim);
        return Result.success(token);

    }

    /**
     * 获取登录用户信息
     */

    @RequestMapping("/getUserInfo")
    public UserInfo getLogInUserInfo(HttpServletRequest  request){
        log.info("获取登录用户信息");

        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        Integer userId = JwtUtils.getIdByToken(token);
        if(userId == null){
            return null;
        }
        UserInfo userInfo = userService.selectById(userId);
        return userInfo;
    }


    /**
     * 根据博客ID来获取作者ID
     * 进而获取作者信息
     */
    @RequestMapping("getAuthorInfo")
    public UserInfo getAuthorInfo(Integer blogId){
        log.info("根据博客ID获取作者ID");
        if(blogId <=0){
            return null;
        }
        return userService.getAuthorId(blogId);
    }






}
