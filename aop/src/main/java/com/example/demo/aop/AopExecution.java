package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Aspect
@Component
public class AopExecution extends AopBase
{
	final static Logger log = LoggerFactory.getLogger(AopExecution.class);

//	*：匹配任何数量字符
//	…：匹配任何数量字符的重复，如在类型模式中匹配任何数量子包；而在方法参数模式中匹配任何数量参数（0个或者多个参数）
//	+：匹配指定类型及其子类型；仅能作为后缀放在类型模式后边

	//Pointcut
	//@Pointcut("execution(* com.example.demo.hello.IHelloWorldServiceImpl.getHiMessage(..))")
	@Pointcut("execution(* com.example.demo.hello.IHelloWorldServiceImpl.*(..))")
	//第一个通配符匹配所有返回值类型，
	//第二个匹配这个类里的所有方法,()括号表示参数列表,括号里的用两个点号表示匹配任意个参数，包括0个
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
		log.info("3.AopExecution Before2"); 
	}

	//After
	@After(value = "pointcut()") 
	public void doAfter1(JoinPoint joinPoint)throws Exception
	{ 
		log.info("6.AopExecution After1 {}", joinPoint);
	}

	@After(value = "pointcut()") 
	public void doAfter2()throws Exception
	{ 
		log.info("7.AopExecution After2");
	}

	//AfterReturning
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning1(JoinPoint joinPoint, Object ret) throws Exception 
    {
    	log.info("8.AopExecution AfterReturning1 {}", ret);
    }
   
    @AfterReturning(returning = "ret", value = "pointcut()")
    public void doAfterReturning2(Object ret) throws Exception 
    {
    	log.info("9.AopExecution AfterReturning2 {}", ret);
    }
 
    @AfterReturning(value = "pointcut()")
    public void doAfterReturning3() throws Exception 
    {
    	log.info("10.AopExecution AfterReturning3 {}");
    }

    //Around
    @Around(value = "pointcut()")  
    public Object doArround1(ProceedingJoinPoint pjp) throws Throwable 
    { 
    	log.info("1.AopExecution Arround1 before proceed" );
    	Object o =  pjp.proceed();
    	log.info("5.AopExecution Arround1 after proceed");
    	return o;
    }
 
    //AfterThrowing
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void doAfterThrow1(JoinPoint joinPoint,  Exception ex)
    {  
    	log.info("AopExecution AfterThrow1 {}", joinPoint);
    }
 
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow2(JoinPoint joinPoint)
    {  
    	log.info("AopExecution AfterThrow2 {}", joinPoint);
    }
    
    @AfterThrowing(value = "pointcut()")
    public void doAfterThrow3()
    {  
    	log.info("AopExecution AfterThrow3");
    }
*/
}
