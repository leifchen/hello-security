package com.chen.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器的接口
 *
 * @Author LeifChen
 * @Date 2018-07-08
 */
public interface ValidateCodeProcessor {

    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建验证码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
}
