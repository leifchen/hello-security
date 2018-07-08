package com.chen.validate.impl;

import com.chen.property.SecurityProperties;
import com.chen.validate.ValidateCode;
import com.chen.validate.ValidateCodeGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器的实现类
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@NoArgsConstructor
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Getter
    @Setter
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 生成短信验证码
     *
     * @param request
     * @return
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }
}
