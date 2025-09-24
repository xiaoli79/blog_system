# 博客系统

这是一个基于 Spring Boot + MyBatis 构建的简单博客系统。

## ✨ 功能特性

* **用户管理**
    * 登录功能
    * 获取用户信息
* **博客管理**
    * 发布博客
    * 删除博客
    * 修改博客
    * 查看博客列表
    * 查看博客详情

## 🚀 技术栈

* **后端**: Spring Boot, MyBatis, MySQL
* **依赖**:
    * `spring-boot-starter-web`: 用于构建 Web 应用
    * `mybatis-spring-boot-starter`: MyBatis 与 Spring Boot 的集成
    * `mysql-connector-j`: MySQL 数据库驱动
    * `lombok`: 简化 Java 代码
    * `jwt`: 用于 JWT (JSON Web Token) 的生成和解析

## 📂 项目结构

```text
├── pom.xml
└── src
├── main
│   ├── java
│   │   └── com
│   │       └── blog_system
│   │           ├── controller
│   │           │   ├── BlogController.java
│   │           │   └── UserController.java
│   │           ├── service
│   │           │   ├── BlogService.java
│   │           │   └── UserService.java
│   │           └── ...
│   └── resources
│       └── ...
└── test
└── ...
```

## 📝 API 接口文档

### 用户接口 (`/user`)

* **POST** `/user/login`
    * **描述**: 用户登录
    * **参数**: `userName`, `password`
    * **返回**: 成功时返回包含 token 的 `Result` 对象。

* **GET** `/user/getUserInfo`
    * **描述**: 获取当前登录用户信息
    * **Header**: 需要在请求头中携带 `token`
    * **返回**: `UserInfo` 对象。

* **GET** `/user/getAuthorInfo`
    * **描述**: 根据博客 ID 获取作者信息
    * **参数**: `blogId`
    * **返回**: `UserInfo` 对象。

### 博客接口 (`/blog`)

* **GET** `/blog/getList`
    * **描述**: 获取所有博客列表
    * **返回**: `List<BlogInfo>`

* **GET** `/blog/getBlogDetail`
    * **描述**: 根据 ID 获取博客详情
    * **参数**: `blogId`
    * **返回**: `BlogInfo` 对象。

* **POST** `/blog/add`
    * **描述**: 发布新博客
    * **Header**: 需要在请求头中携带 `token`
    * **Body**: `BlogInfo` 对象的 JSON
    * **返回**: `boolean`

* **POST** `/blog/update`
    * **描述**: 更新博客
    * **Body**: `BlogInfo` 对象的 JSON (必须包含 `id`)
    * **返回**: `Boolean`

* **POST** `/blog/delete`
    * **描述**: 删除博客 (逻辑删除)
    * **参数**: `blogId`
    * **返回**: `Boolean`

## 启动项目

1.  配置 `application.yml` 中的数据库连接信息。
2.  创建对应的数据库和表。
3.  运行 `BlogSystemApplication.java`。



