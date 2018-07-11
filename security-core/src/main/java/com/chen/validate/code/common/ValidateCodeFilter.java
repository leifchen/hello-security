package com.chen.validate.code.common;

import com.chen.constant.SecurityConstant;
import com.chen.constant.ValidateCodeTypeEnum;
import com.chen.property.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ValidateCodeFilter
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private static final String METHOD_GET = "GET";

    /**
     * 系统配置信息
     */
    private final SecurityProperties securityProperties;

    /**
     * 验证码校验失败处理器
     */
    @Resource
    private AuthenticationFailureHandler myAuthenticationFailureHandler;

    /**
     * 系统中的校验码处理器
     */
    @Resource
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 存放所以需要校验码的url
     */
    private Map<String, ValidateCodeTypeEnum> urlMap = new HashMap<>();

    /**
     * 验证请求url与配置的url是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    public ValidateCodeFilter(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * 初始化要拦截的url配置信息
     *
     * @throws ServletException
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        urlMap.put(SecurityConstant.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeTypeEnum.IMAGE);
        addUrlToMap(securityProperties.getCode().getImage().getUrl(), ValidateCodeTypeEnum.IMAGE);

        urlMap.put(SecurityConstant.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeTypeEnum.SMS);
        addUrlToMap(securityProperties.getCode().getSms().getUrl(), ValidateCodeTypeEnum.SMS);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ValidateCodeTypeEnum type = getValidateCodeType(request);
        if (type != null) {
            log.info("校验请求({})中的验证码，类型为{}", request.getRequestURI(), type);
            try {
                validateCodeProcessorHolder.findValidateCodeProcessor(type)
                        .validate(new ServletWebRequest(request, response));
                log.info("验证码校验通过");
            } catch (ValidateCodeException e) {
                myAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    /**
     * 将系统中配置的需要校验码的URL根据类型放入map
     *
     * @param urlString
     * @param type
     */
    private void addUrlToMap(String urlString, ValidateCodeTypeEnum type) {
        if (StringUtils.isNotBlank(urlString)) {
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
            for (String url : urls) {
                urlMap.put(url, type);
            }
        }
    }

    /**
     * 获取校验码的类型，如果当前请求不需要校验，则返回null
     *
     * @param request
     * @return
     */
    private ValidateCodeTypeEnum getValidateCodeType(HttpServletRequest request) {
        ValidateCodeTypeEnum result = null;
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), METHOD_GET)) {
            Set<String> urls = urlMap.keySet();
            for (String url : urls) {
                if (pathMatcher.match(url, request.getRequestURI())) {
                    result = urlMap.get(url);
                }
            }
        }
        return result;
    }
}
