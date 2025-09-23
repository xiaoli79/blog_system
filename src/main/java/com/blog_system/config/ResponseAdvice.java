package com.blog_system.config;
import com.blog_system.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;



//统一结果返回
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    private final ObjectMapper objectMapper;

    public ResponseAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
       if(body instanceof Result){
           return body;
       }
       if(body instanceof String){
           try {
               return objectMapper.writeValueAsString(Result.success(body));
           } catch (JsonProcessingException e) {
               throw new RuntimeException(e);
           }
       }
       return Result.success(body);
    }
}
