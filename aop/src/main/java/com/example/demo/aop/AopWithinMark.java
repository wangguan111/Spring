package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopWithinMark extends AopBase
{
	final static Logger log = LoggerFactory.getLogger(AopWithinMark.class);
	
	//Pointcut
	//@within：用于匹配在类一级使用了参数确定的注解的类，其所有方法都将被匹配。
	//所有被@AopInterfaceClass标注的类都将匹配
	//要求RetentionPolicy级别为CLASS
	@Pointcut("@within(com.example.demo.aop.AopInterfaceClass)")
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
		log(joinPoint);
	}
/*
	@Before(value = "pointcut()") 
	public void doBefore2()throws Exception
	{
		log.info("3.AopWithinMark Before2"); 
	}

	//After
	@After(value = "pointcut()") 
	public void doAfter1(JoinPoint joinPoint)throws Exception
	{ 
		log.info("6.AopWithinMark After1 {}", joinPoint);
	}

	@After(value = "pointcut()") 
	public void doAfter2()throws Exception
	{ 
		log.info("7.AopWithinMark After2");
	}

	//AfterReturning
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning1(JoinPoint joinPoint, Object ret) throws Exception 
    {
    	log.info("8.AopWithinMark AfterReturning1 {}", ret);
    }
   
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning2(Object ret) throws Exception 
    {
    	log.info("9.AopWithinMark AfterReturning2 {}", ret);
    }
 
    @AfterReturning(value = "pointcut()")
    public void doAfterReturning3() throws Exception 
    {
    	log.info("10.AopWithinMark AfterReturning3 {}");
    }

    //Around
    @Around(value = "pointcut()")  
    public Object doArround1(ProceedingJoinPoint pjp) throws Throwable 
    { 
    	log.info("1.AopWithinMark Arround1 before proceed" );
    	Object o =  pjp.proceed();
    	log.info("5.AopWithinMark Arround1 after proceed");
    	return o;
    }
 
    //AfterThrowing
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void doAfterThrow1(JoinPoint joinPoint,  Exception ex)
    {  
    	log.info("AopWithinMark AfterThrow1 {}", joinPoint);
    }
 
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow2(JoinPoint joinPoint)
    {  
    	log.info("AopWithinMark AfterThrow2 {}", joinPoint);
    }
    
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow3()
    {  
    	log.info("AopWithinMark AfterThrow3");
    }
*/
}
