package com.chen.validate.serivce;

/**
 * 短信验证码发送器
 *
 * @Author LeifChen
 * @Date 2018-07-08
 */
public interface SmsCodeSender {

    /**
     * 发送短信验证码
     *
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
