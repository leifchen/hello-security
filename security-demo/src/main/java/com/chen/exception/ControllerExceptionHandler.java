package com.chen.exception;

import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * ControllerExceptionHandler
 * @Author LeifChen
 * @Date 2018-07-02
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNoExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNoExistException(UserNoExistException ex) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }
}
