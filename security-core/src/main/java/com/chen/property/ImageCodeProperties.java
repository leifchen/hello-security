package com.chen.property;

import lombok.Getter;
import lombok.Setter;

/**
 * ImageCodeProperties
 *
 * @Author LeifChen
 * @Date 2018-07-07
 */
@Getter
@Setter
public class ImageCodeProperties {

    /**
     * 宽
     */
    private int width = 60;

    /**
     * 高
     */
    private int height = 20;

    /**
     * 字符长度
     */
    private int length = 4;

    /**
     * 有效时间
     */
    private int expireIn = 60;

    /**
     * 请求url
     */
    private String url;
}
