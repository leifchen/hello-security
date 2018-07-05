package com.chen.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * JsonData
 *
 * @Author LeifChen
 * @Date 2018-07-04
 */
public class JsonData {

    public JsonData(Object content) {
        this.content = content;
    }

    @Getter
    @Setter
    private Object content;
}
