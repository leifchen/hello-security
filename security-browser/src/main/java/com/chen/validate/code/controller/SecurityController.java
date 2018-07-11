package com.chen.validate.code.controller;

import com.chen.bean.JsonData;
import com.chen.property.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SecurityController
 *
 * @Author LeifChen
 * @Date 2018-07-04
 */
@RestController
@Slf4j
public class SecurityController {

    private static final String END_WITH_HTML = ".html";

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private final SecurityProperties securityProperties;

    @Autowired
    public SecurityController(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * 需要身份认证的跳转页面
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/auth/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public JsonData requireAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是：{}", targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, END_WITH_HTML)) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }

        return new JsonData("访问的服务器需要身份认证，请引导用户到登陆页");
    }
}
