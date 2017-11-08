package com.payease.handle;

import com.payease.domain.Result;
import com.payease.enums.ResultEnum;
import com.payease.exception.GirlException;
import com.payease.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常捕获类
 * Created by liuxiaoming on 2017/11/7.
 */
@ControllerAdvice
public class ExceptionHandle {

    //日志
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.info("【系统异常】{}",e);
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
            //return ResultUtil.error(-1,"未知错误：");
        }

    }
}
