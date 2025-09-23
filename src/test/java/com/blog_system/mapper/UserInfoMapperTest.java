package com.blog_system.mapper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void selectByName() {
        userInfoMapper.selectByName("admin");
    }

    @Test
    void selectById() {
        userInfoMapper.selectById(1);
    }

    @Test
    void insert() {
    }
}