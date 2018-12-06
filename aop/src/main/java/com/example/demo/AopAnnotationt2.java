package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
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

@SuppressWarnings("unused")
@Aspect
@Component
public class AopAnnotationt2 
{
	final static Logger log = LoggerFactory.getLogger(AopAnnotationt2.class);
	
	//Pointcut
	@Pointcut(value = "@annotation(AopInterface)") 
	public void pointcut() 
	{ }
	
	//Before
	@Before(value = "pointcut()") 
	public void doBefore1(JoinPoint joinPoint)throws Exception
	{
		log.info("2.AopAnnotationt2 Before1 {}", joinPoint);
		
		//获取目标方法的参数信息 
		//java
	    Object[] obj = joinPoint.getArgs();
		log.info("2.AopAnnotationt2 joinPoint.getArgs() {}", joinPoint.getArgs());

	    //AOP代理类的信息
		//com.example.demo.IHelloWorldServiceImpl@73032858
		log.info("2.AopAnnotationt2 joinPoint.getThis() {}", joinPoint.getThis());

	    //代理的目标对象
		//com.example.demo.IHelloWorldServiceImpl@73032858
		log.info("2.AopAnnotationt2 joinPoint.getTarget() {}", joinPoint.getTarget());

	    //用的最多 通知的签名
		//String com.example.demo.IHelloWorldServiceImpl.getHiMessage(String)
	    Signature signature = joinPoint.getSignature();
		log.info("2.AopAnnotationt2 joinPoint.getSignature() {}", joinPoint.getSignature());
		
	    //代理的是哪一个方法
		//getHiMessage
		log.info("2.AopAnnotationt2 signature.getSignature() {}", signature.getName());

	    //AOP代理类的名字
		//com.example.demo.IHelloWorldServiceImpl
		log.info("2.AopAnnotationt2 signature.getDeclaringTypeName() {}", signature.getDeclaringTypeName());

	    //AOP代理类的类（class）信息
		//class com.example.demo.IHelloWorldServiceImpl
		log.info("2.AopAnnotationt2 signature.getDeclaringType() {}", signature.getDeclaringType());	
	}
/*
	@Before(value = "pointcut()") 
	public void doBefore2()throws Exception
	{
		log.info("3.AopAnnotationt2 Before2"); 
	}

	//After
	@After(value = "pointcut()") 
	public void doAfter1(JoinPoint joinPoint)throws Exception
	{ 
		log.info("6.AopAnnotationt2 After1 {}", joinPoint);
	}

	@After(value = "pointcut()") 
	public void doAfter2()throws Exception
	{ 
		log.info("7.AopAnnotationt2 After2");
	}

	//AfterReturning
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning1(JoinPoint joinPoint, Object ret) throws Exception 
    {
    	log.info("8.AopAnnotationt2 AfterReturning1 {} {}", ret, joinPoint);
    }
   
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning2(Object ret) throws Exception 
    {
    	log.info("9.AopAnnotationt2 AfterReturning2 {}", ret);
    }
 
    @AfterReturning(value = "pointcut()")
    public void doAfterReturning3() throws Exception 
    {
    	log.info("10.AopAnnotationt2 AfterReturning3");
    }

    //Around
    @Around(value = "pointcut()")  
    public Object doArround1(ProceedingJoinPoint pjp) throws Throwable 
    { 
    	log.info("1.AopAnnotationt2 Arround1 before proceed");
    	Object o =  pjp.proceed();
    	log.info("5.AopAnnotationt2 Arround1 after proceed");
    	return o;
    }
 
    //AfterThrowing
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void doAfterThrow1(JoinPoint joinPoint, Exception ex)
    {  
    	log.info("AopAnnotationt2 AfterThrow1 {}", joinPoint);
    }
 
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow2(JoinPoint joinPoint)
    {  
    	log.info("AopAnnotationt2 AfterThrow2 {}", joinPoint);
    }
    
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow3()
    {  
    	log.info("AopAnnotationt2 AfterThrow3");
    }
 */   
}
