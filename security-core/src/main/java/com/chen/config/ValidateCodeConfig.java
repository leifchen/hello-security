package com.chen.config;

import com.chen.property.SecurityProperties;
import com.chen.validate.ImageCodeGenerator;
import com.chen.validate.ValidateCodeGenerator;
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

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }
}
