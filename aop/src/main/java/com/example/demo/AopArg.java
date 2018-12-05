package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@SuppressWarnings("unused")
@Component
public class AopArg 
{
	final static Logger log = LoggerFactory.getLogger(AopArg.class);
	
	//Pointcut
	//匹配所有getHiMessage的String参数方法
	@Pointcut(value = "execution(public * com.example.demo.IHelloWorldServiceImpl.getHiMessage(*)) && args(name)", argNames = "name")
	public void pointcut(String name) 
	{ }
	
	//Before
	//不能有JoinPoint参数
	@Before(value = "pointcut(name)", argNames = "name")
	public void doBefore2(String name)throws Exception
	{
		log.info("3.AopArg Before2"); 
	}
/*
	//After
	//不能有JoinPoint参数
	@After(value = "pointcut(name)", argNames = "name") 
	public void doAfter2(String name)throws Exception
	{ 
		log.info("7.AopArg After2");
	}

	//@AfterReturning
	//不能有JoinPoint参数
    @AfterReturning(value = "pointcut(name)", argNames = "name")
    public void doAfterReturning3(String name) throws Exception 
    {
    	log.info("10.AopArg AfterReturning3 {}");
    }

    //Around
    //不能有JoinPoint参数
    @Around(value = "pointcut(name)", argNames = "name")  
    public Object doArround1(ProceedingJoinPoint pjp, String name) throws Throwable 
    { 
    	log.info("1.AopArg Arround1 before proceed {}", name);
    	Object o =  pjp.proceed();
    	log.info("5.AopArg Arround1 after proceed {}", name);
    	return o;
    }
 
    //AfterThrowing
 	//不能有JoinPoint参数
    @AfterThrowing(value = "pointcut(name)", argNames = "name") 
    public void doAfterThrow3(String name)
    {  
    	log.info("AopArg AfterThrow3 {}", name);
    }
*/
}
