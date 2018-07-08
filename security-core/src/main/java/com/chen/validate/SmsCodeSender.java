package com.chen.validate;

/**
 * 短信验证码发送器
 *
 * @Author LeifChen
 * @Date 2018-07-08
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
