package com.chen.validate.serivce;

import com.chen.validate.bean.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成器的接口
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
    ValidateCode generate(ServletWebRequest request);
}