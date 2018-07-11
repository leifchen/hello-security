package com.chen.validate.code.common;


import org.springframework.security.core.AuthenticationException;

/**
 * ValidateCodeException
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String message) {
        super(message);
    }
}
