package com.blog_system.mapper;

import com.blog_system.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserInfoMapper {

//    根据用户名，查询用户信息
    @Select("select * from user_info where delete_flag = 0 and user_name =#{userName}")
    UserInfo selectByName(String userName);

//  根据用户ID，查询用户信息

    @Select("select * from user_info where delete_flag = 0 and id =#{id}")
    UserInfo selectById(Integer id);






//    登录
    @Insert("insert into user_info (user_name,password) values(#{userName},#{password})")
    Integer insert(String userName, String password);
}
