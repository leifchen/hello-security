package com.chen.property;

import lombok.Getter;
import lombok.Setter;

/**
 * 验证码的配置属性文件
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@Getter
@Setter
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();
    private SmsCodeProperties sms = new SmsCodeProperties();
}
