package com.payease.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuxiaoming on 2017/11/7.
 */
@Aspect
@Component
public class HttpAspect {

    //日志 为logger.info()提供
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 公共方法
     */
    @Pointcut("execution(public * com.payease.controller.GirlController.*(..))")
    public void log(){
        logger.info("@Pointcut 公共方法：拦截请求aop！");
    }

    /**
     * 方法执行之前
     */
    //@Before("execution(public * com.payease.controller.GirlController.*(..))")
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("1。@Before 拦截请求aop！");

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
            logger.info("url={}", request.getRequestURL());
        //method
            logger.info("method={}", request.getMethod());
        //ip
            logger.info("ip={}", request.getRemoteAddr());
        //类方法
            logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName());
        //参数
            logger.info("args={}", joinPoint.getArgs());

    }

    /**
     * 方法执行之后
     */
    @After("log()")
    public void doAfter(){
        logger.info("2。@After 拦截请求aop！");
    }

    /**
     * 获取返回值
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
