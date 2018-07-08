package com.chen.property;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片验证码的配置属性文件
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@Getter
@Setter
public class ImageCodeProperties extends SmsCodeProperties {

    /**
     * 默认长度为4位
     */
    public ImageCodeProperties() {
        setLength(4);
    }

    /**
     * 宽
     */
    private int width = 60;

    /**
     * 高
     */
    private int height = 20;
}
