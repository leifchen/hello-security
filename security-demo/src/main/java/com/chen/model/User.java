package com.chen.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * User
 * @Author LeifChen
 * @Date 2018-06-28
 */
@Getter
@Setter
public class User {

    public interface UserSimpleView {}

    public interface UserDetailView extends UserSimpleView {}

    @JsonView(UserSimpleView.class)
    private int id;

    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    private String password;

    @JsonView(UserSimpleView.class)
    private Date birthday;
}
