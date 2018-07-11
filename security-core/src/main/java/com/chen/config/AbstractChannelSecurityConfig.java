package com.chen.config;

import com.chen.constant.SecurityConstant;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;

/**
 * ValidateCodeConfig
 *
 * @Author LeifChen
 * @Date 2018-07-11
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	
	@Resource
	protected AuthenticationFailureHandler myAuthenticationFailureHandler;
	
	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstant.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstant.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(myAuthenticationSuccessHandler)
			.failureHandler(myAuthenticationFailureHandler);
	}
}
