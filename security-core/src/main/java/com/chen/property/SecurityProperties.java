package com.chen.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SecurityProperties
 *
 * @Author LeifChen
 * @Date 2018-07-04
 */
@ConfigurationProperties(prefix = "chen.security")
@Getter
@Setter
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();
}
