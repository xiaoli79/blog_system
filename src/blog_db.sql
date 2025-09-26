-- 创建数据库
CREATE DATABASE IF NOT EXISTS java_blog_spring CHARSET utf8mb4;
USE java_blog_spring;

-- 用户表
DROP TABLE IF EXISTS java_blog_spring.user_info;
CREATE TABLE java_blog_spring.user_info (
                                            id INT NOT NULL AUTO_INCREMENT,
                                            user_name VARCHAR(128) NOT NULL,
                                            password VARCHAR(128) NOT NULL,
                                            github_url VARCHAR(128) NULL,
                                            delete_flag TINYINT(4) NULL DEFAULT 0,
                                            create_time DATETIME DEFAULT NOW(),
                                            update_time DATETIME DEFAULT NOW() ON UPDATE NOW(),
                                            PRIMARY KEY (id),
                                            UNIQUE INDEX user_name_UNIQUE (user_name ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 博客表
DROP TABLE IF EXISTS java_blog_spring.blog_info;
CREATE TABLE java_blog_spring.blog_info (
                                            id INT NOT NULL AUTO_INCREMENT,
                                            title VARCHAR(200) NULL,
                                            content TEXT NULL,
                                            user_id INT(11) NULL,
                                            delete_flag TINYINT(4) NULL DEFAULT 0,
                                            create_time DATETIME DEFAULT NOW(),
                                            update_time DATETIME DEFAULT NOW() ON UPDATE NOW(),
                                            PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客表';

-- 插入用户数据
INSERT INTO java_blog_spring.user_info (user_name, password, github_url)
VALUES ('zhangsan', 'e5b43eb1f0664ea49fa44cb485ce1bcbe603cfe6240ddbc462ac905d6e853370', 'https://gitee.com/bubble-fish666/class-java45');

INSERT INTO java_blog_spring.user_info (user_name, password, github_url)
VALUES ('lisi', '123456', 'https://gitee.com/bubble-fish666/class-java45');

-- 插入博客数据
INSERT INTO java_blog_spring.blog_info (title, content, user_id)
VALUES ('第一篇博客', '111我是博客正文我是博客正文我是博客正文', 1);

INSERT INTO java_blog_spring.blog_info (title, content, user_id)
VALUES ('第二篇博客', '222我是博客正文我是博客正文我是博客正文', 2);