package com.chen.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * UserNoExistException
 * @Author LeifChen
 * @Date 2018-07-02
 */
public class UserNoExistException extends RuntimeException {

    @Getter
    @Setter
    private String id;

    public UserNoExistException(String id) {
        super("user not exist");
        this.id = id;
    }
}
