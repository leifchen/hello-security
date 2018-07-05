package com.chen.config;

import com.chen.property.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * SecurityCoreConfig
 *
 * @Author LeifChen
 * @Date 2018-07-04
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
