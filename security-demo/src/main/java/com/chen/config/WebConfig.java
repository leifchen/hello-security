package com.chen.config;

import com.chen.filter.TimeFilter;
import com.chen.interceptor.TimeInterceptor;
import org.assertj.core.util.Lists;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * WebConfig
 * @Author LeifChen
 * @Date 2018-07-02
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = Lists.newArrayList();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}
