package com.chen.browser.bean;

import com.chen.validate.code.common.ValidateCodeGenerator;
import com.chen.validate.code.image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * DemoImageCodeGenerator
 *
 * @Author LeifChen
 * @Date 2018-07-08
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成器");
        return null;
    }
}
