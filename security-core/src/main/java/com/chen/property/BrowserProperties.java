package com.chen.property;

import com.chen.constant.LoginTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * BrowserProperties
 *
 * @Author LeifChen
 * @Date 2018-07-04
 */
@Getter
@Setter
public class BrowserProperties {

    private String loginPage = "/login.html";

    private LoginTypeEnum loginType = LoginTypeEnum.JSON;

    private int rememberMeSeconds = 3600;
}
