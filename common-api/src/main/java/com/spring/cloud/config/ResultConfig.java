package com.spring.cloud.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultConfig<T> {
    private Integer code;
    private String message;
    private T date;

    public ResultConfig(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.date = null;
    }

}
