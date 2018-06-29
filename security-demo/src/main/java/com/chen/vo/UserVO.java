package com.chen.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * UserVO
 * @Author LeifChen
 * @Date 2018-06-28
 */
@Getter
@Setter
@ToString
public class UserVO {

    @NotBlank(message = "用户名不能为空")
    private String username;
    private Date birthday;
}
