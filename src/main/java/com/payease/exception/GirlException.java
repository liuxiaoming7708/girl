package com.payease.exception;

import com.payease.enums.ResultEnum;

/**
 * 自定义异常
 * Created by liuxiaoming on 2017/11/7.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
