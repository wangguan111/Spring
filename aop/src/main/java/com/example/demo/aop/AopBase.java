package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gilbertwang
 */
public class AopBase
{
    final static Logger log = LoggerFactory.getLogger(AopBase.class);

    protected void log(JoinPoint joinPoint)
    {
        log.info(this.toString());
        //获取目标方法的参数信息
        log.info("joinPoint.getArgs() {}", joinPoint.getArgs());

        //AOP代理类的信息
        //com.example.demo.hello.IHelloWorldServiceImpl@73032858
        log.info("joinPoint.getThis() {}", joinPoint.getThis());

        //代理的目标对象
        //com.example.demo.hello.IHelloWorldServiceImpl@73032858
        log.info("joinPoint.getTarget() {}", joinPoint.getTarget());

        //用的最多 通知的签名
        //String com.example.demo.hello.IHelloWorldServiceImpl.getHiMessage(String)
        log.info("joinPoint.getSignature() {}", joinPoint.getSignature());

        //代理的是哪一个方法
        //getHiMessage
        log.info("signature.getSignature() {}", joinPoint.getSignature().getName());

        //AOP代理类的名字
        //com.example.demo.hello.IHelloWorldServiceImpl
        log.info("signature.getDeclaringTypeName() {}", joinPoint.getSignature().getDeclaringTypeName());

        //AOP代理类的类（class）信息
        //class com.example.demo.hello.IHelloWorldServiceImpl
        log.info("signature.getDeclaringType() {}", joinPoint.getSignature().getDeclaringType());
    }
}
