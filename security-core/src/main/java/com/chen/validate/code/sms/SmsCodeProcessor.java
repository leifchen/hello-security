package com.chen.validate.code.sms;

import com.chen.constant.SecurityConstant;
import com.chen.validate.code.common.ValidateCode;
import com.chen.validate.code.common.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;

/**
 * 短信验证码处理器
 *
 * @Author LeifChen
 * @Date 2018-07-08
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    /**
     * 短信验证码发送器
     */
    @Resource
    private SmsCodeSender smsCodeSender;

    /**
     * 发送短信验证码
     */
    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstant.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, validateCode.getCode());
    }

}
