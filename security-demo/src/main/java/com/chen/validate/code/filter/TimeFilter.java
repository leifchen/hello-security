package com.chen.validate.code.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * TimeFilter
 * @Author LeifChen
 * @Date 2018-07-02
 */
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时:" + (System.currentTimeMillis() - start));
        System.out.println("time filter end");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
