package com.blog_system.config;


import com.blog_system.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




//统一异常返回~
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    public Result handle(Exception e){
        log.error("发生异常，e",e);
        return Result.fail("内部错误，请联系管理员");
    }

}
