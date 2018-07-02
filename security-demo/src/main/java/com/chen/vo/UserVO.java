package com.chen.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
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

    @Past(message = "生日必须为过去的时间")
    private Date birthday;
}
