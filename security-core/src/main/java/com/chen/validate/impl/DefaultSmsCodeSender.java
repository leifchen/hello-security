package com.chen.validate.impl;

import com.chen.validate.SmsCodeSender;

/**
 * 默认的短信验证码发送器
 *
 * @Author LeifChen
 * @Date 2018-07-08
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    /**
     * 向手机发送验证码
     * @param mobile
     * @param code
     */
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }
}
