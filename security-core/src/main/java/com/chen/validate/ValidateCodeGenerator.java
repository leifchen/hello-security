package com.chen.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * ValidateCodeGenerator
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
public interface ValidateCodeGenerator {

    /**
     * 生成图形验证码
     *
     * @param request
     * @return
     */
    ImageCode generate(ServletWebRequest request);
}
