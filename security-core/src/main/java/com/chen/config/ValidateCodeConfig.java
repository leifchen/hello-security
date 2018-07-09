package com.chen.config;

import com.chen.property.SecurityProperties;
import com.chen.validate.serivce.impl.DefaultSmsCodeSender;
import com.chen.validate.serivce.impl.ImageCodeGenerator;
import com.chen.validate.serivce.impl.SmsCodeGenerator;
import com.chen.validate.serivce.SmsCodeSender;
import com.chen.validate.serivce.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ValidateCodeConfig
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@Configuration
public class ValidateCodeConfig {

    private SecurityProperties securityProperties;

    @Autowired
    public ValidateCodeConfig(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Bean("imageValidateCodeGenerator")
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean("smsValidateCodeGenerator")
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public ValidateCodeGenerator smsCodeGenerator() {
        SmsCodeGenerator codeGenerator = new SmsCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
