package com.chen.controller;

import com.chen.validate.ImageCode;
import com.chen.validate.SmsCodeSender;
import com.chen.validate.ValidateCode;
import com.chen.validate.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ValidateCodeController
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Resource
    private SmsCodeSender smsCodeSender;

    /**
     * 生成图片验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/code/image")
    public void createImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    /**
     * 生成短信验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, smsCode);
        String mobile = ServletRequestUtils.getStringParameter(request, "mobile");
        smsCodeSender.send(mobile, smsCode.getCode());
    }
}
