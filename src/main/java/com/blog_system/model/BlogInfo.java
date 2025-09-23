package com.blog_system.model;


import com.blog_system.utils.DateUtils;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {
    private Integer id;
    private String title;
    private Integer userId;
    private boolean loginUser;
    private String content;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;


    public String getCreateTime() {
        return DateUtils.dateFormat(createTime);
    }
}
