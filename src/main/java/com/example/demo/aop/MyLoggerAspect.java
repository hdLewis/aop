package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect//标注当前类为切面
@Component
public class MyLoggerAspect {
    /**
     * @Before:将方法指定为前置通知
     * 必须设置value,其值为切入点表达式
     */
    @Before(value = "execution(public int com.example.demo.proxy.MathImpl.add(int,int))")
    public  void beforeMethod(){
        System.out.println("方法执行之前");
    }
}