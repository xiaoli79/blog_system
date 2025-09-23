package com.blog_system.mapper;

import com.blog_system.model.BlogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface BlogMapper {

    /**
     *返回博客列表
     *
     */
    @Select("select * from blog_info")
    List<BlogInfo> selectAll();

    /**
     * 根据博客ID，返回博客信息
     * @param id
     * @return
     */
    @Select("select * from blog_info where id=#{id}")
    BlogInfo selectById(Integer id);

    /**
     * 更新博客
     * @param blogInfo
     * @return
     */

    Integer updateBlog(BlogInfo blogInfo);

    /**
     * 发布博客
     * @param blogInfo
     * @return
     */

    @Insert("insert into blog_info (title,content,user_id) values (#{title},#{content},#{userId})")
    Integer insertBlog(BlogInfo blogInfo);



}
