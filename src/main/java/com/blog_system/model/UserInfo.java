package com.blog_system.model;


import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private String githubUrl;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
