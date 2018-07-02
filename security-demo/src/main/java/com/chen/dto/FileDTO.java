package com.chen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * FileDTO
 * @Author LeifChen
 * @Date 2018-07-02
 */
@ToString
@Getter
@Setter
public class FileDTO {

    public FileDTO(String path) {
        this.path = path;
    }

    private String path;
}
