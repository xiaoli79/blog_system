package com.blog_system.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class SecurityUtils {
    /**
     * 对密码进行加密
     * @param password
     * @return
     */


 public static String encrypt(String password){
//     生成盐值
     String salt = UUID.randomUUID().toString().replace("-","");
//     对盐值+明文进行MD5加密
     String finalPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
     return salt + finalPassword;
 }
 /**
     * 验证密码
     * @param inputPassword
     * @param sqlPassword
     * @return
     */

public static boolean verify(String inputPassword,String sqlPassword){
     if(!StringUtils.hasLength(inputPassword)){
         return false;
     }
     if(sqlPassword == null || sqlPassword.length() != 64){
         return false;
     }


     //获取盐值
     String salt = sqlPassword.substring(0,32);
     //根据用户登录输入的密码和盐值，进行加密~~ md5(盐值+明文)
     String finalPassword = DigestUtils.md5DigestAsHex((salt+inputPassword).getBytes());
     return sqlPassword.equals(salt + finalPassword);
}

    public static void main(String[] args) {
        System.out.println(encrypt("123456"));
        System.out.println(verify("123456","faaf126c19504efd8a47978666c1a7c1b430c17858a8723ed445d00495be0ebf"));
    }

}
