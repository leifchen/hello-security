package com.chen.property;

import lombok.Getter;
import lombok.Setter;

/**
 * 短信验证码的配置属性文件
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@Getter
@Setter
public class SmsCodeProperties {

    /**
     * 长度
     */
    private int length = 6;

    /**
     * 有效时间
     */
    private int expireIn = 60;

    /**
     * 请求url
     */
    private String url;
}
