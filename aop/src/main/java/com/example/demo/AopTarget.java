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

@SuppressWarnings("unused")
@Aspect
@Component
public class AopTarget 
{
	final static Logger log = LoggerFactory.getLogger(AopThis.class);
	
	//Pointcut
	//连接所有anObject.instanceof(AType)
	//this(AType)同接受者方面描述，target(AType)则从调用者方面描述
	@Pointcut("target(com.example.demo.IHelloWorldServiceImpl)")
	public void pointcut() 
	{ }
	
	//除了@Around外，每个方法里都可以加或者不加参数JoinPoint,
	//JoinPoint里包含了类名、被切面的方法名，参数等属性，可供读取使用。
	//@Around参数必须为ProceedingJoinPoint，pjp.proceed相应于执行被切面的方法。
	//@AfterReturning方法里，可以加returning = “XXX”，XXX即为在controller里方法的返回值.
	//@AfterThrowing方法里，可以加throwing = "XXX"，供读取异常信息.
	
	//Before
	@Before(value = "pointcut()") 
	public void doBefore1(JoinPoint joinPoint)throws Exception
	{
		log.info("2.AopTarget Before1 {}", joinPoint); 
	}
/*
	@Before(value = "pointcut()") 
	public void doBefore2()throws Exception
	{
		log.info("3.AopTarget Before2"); 
	}

	//After
	@After(value = "pointcut()") 
	public void doAfter1(JoinPoint joinPoint)throws Exception
	{ 
		log.info("6.AopTarget After1 {}", joinPoint);
	}

	@After(value = "pointcut()") 
	public void doAfter2()throws Exception
	{ 
		log.info("7.AopTarget After2");
	}

	//AfterReturning
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning1(JoinPoint joinPoint, Object ret) throws Exception 
    {
    	log.info("8.AopTarget AfterReturning1 {}", ret);
    }
   
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning2(Object ret) throws Exception 
    {
    	log.info("9.AopTarget AfterReturning2 {}", ret);
    }
 
    @AfterReturning(value = "pointcut()")
    public void doAfterReturning3() throws Exception 
    {
    	log.info("10.AopTarget AfterReturning3 {}");
    }

    //Around
    @Around(value = "pointcut()")  
    public Object doArround1(ProceedingJoinPoint pjp) throws Throwable 
    { 
    	log.info("1.AopTarget Arround1 before proceed" );
    	Object o =  pjp.proceed();
    	log.info("5.AopTarget Arround1 after proceed");
    	return o;
    }
 
    //AfterThrowing
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void doAfterThrow1(JoinPoint joinPoint,  Exception ex)
    {  
    	log.info("AopTarget AfterThrow1 {}", joinPoint);
    }
 
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow2(JoinPoint joinPoint)
    {  
    	log.info("AopTarget AfterThrow2 {}", joinPoint);
    }
    
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow3()
    {  
    	log.info("AopTarget AfterThrow3");
    }
*/
}
