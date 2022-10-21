package com.changgou.exception.handler;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 全局异常捕获
 * @author: zhaozl
 * @date: 2022-10-21 09:49
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    /**
     * @Description: 异常处理
     * @Param: Exception
     * @return: Result
     * @Author: zhaozl
     * @Date: 2022/10/21
     * */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result gerError(Exception e){
        e.printStackTrace();
        return  new Result(false, StatusCode.ERROR,e.getMessage());
    }

}
