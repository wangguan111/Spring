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
public class AopAnnotationt extends AopBase
{
	final static Logger log = LoggerFactory.getLogger(AopAnnotationt.class);

	@Pointcut(value = "@annotation(analysisActuator)") 
	public void pointcut(AopInterfaceMethod analysisActuator)
	{ }
	
	//除了@Around外，每个方法里都可以加或者不加参数JoinPoint,
	//JoinPoint里包含了类名、被切面的方法名，参数等属性，可供读取使用。
	//@Around参数必须为ProceedingJoinPoint，pjp.proceed相应于执行被切面的方法。
	//@AfterReturning方法里，可以加returning = “XXX”，XXX即为在controller里方法的返回值.
	//@AfterThrowing方法里，可以加throwing = "XXX"，供读取异常信息.

	@Before(value = "pointcut(analysisActuator)") 
	public void doBefore1(JoinPoint joinPoint, AopInterfaceMethod analysisActuator)throws Exception
	{
		log(joinPoint);
	}
/*
	@Before(value = "pointcut(analysisActuator)") 
	public void doBefore2(AopInterface analysisActuator)throws Exception
	{
		log.info("3.AopAnnotationt Before2 {}", analysisActuator.note()); 
	}

	//After
	@After(value = "pointcut(analysisActuator)") 
	public void doAfter1(JoinPoint joinPoint, AopInterface analysisActuator)throws Exception
	{ 
		log.info("6.AopAnnotationt After1 {}", analysisActuator.note());
	}

	@After(value = "pointcut(analysisActuator)") 
	public void doAfter2(AopInterface analysisActuator)throws Exception
	{ 
		log.info("7.AopAnnotationt After2 {}", analysisActuator.note());
	}

	//AfterReturning
    @AfterReturning(returning = "ret", value = "pointcut(analysisActuator)")
    public void doAfterReturning1(JoinPoint joinPoint, Object ret, AopInterface analysisActuator) throws Exception 
    {
    	log.info("8.AopAnnotationt AfterReturning1 {} {}", ret, analysisActuator.note());
    }
   
    @AfterReturning(returning = "ret", value = "pointcut(analysisActuator)")
    public void doAfterReturning2(Object ret, AopInterface analysisActuator) throws Exception 
    {
    	log.info("9.AopAnnotationt AfterReturning2 {} {}", ret, analysisActuator.note());
    }
 
    @AfterReturning(value = "pointcut(analysisActuator)")
    public void doAfterReturning3(AopInterface analysisActuator) throws Exception 
    {
    	log.info("10.AopAnnotationt AfterReturning3 {}", analysisActuator.note());
    }

    //Around
    @Around(value = "pointcut(analysisActuator)")  
    public Object doArround1(ProceedingJoinPoint pjp, AopInterface analysisActuator) throws Throwable 
    { 
    	log.info("1.AopAnnotationt Arround1 before proceed {}", analysisActuator.note());
    	Object o =  pjp.proceed();
    	log.info("5.AopAnnotationt Arround1 after proceed {}", analysisActuator.note());
    	return o;
    }
 
    //AfterThrowing
    @AfterThrowing(value = "pointcut(analysisActuator)", throwing = "ex")
    public void doAfterThrow1(JoinPoint joinPoint, AopInterface analysisActuator, Exception ex)
    {  
    	log.info("AopAnnotationt AfterThrow1 {}", analysisActuator.note());
    }
 
    @AfterThrowing(value = "pointcut(analysisActuator)")
    public void doAfterThrow2(JoinPoint joinPoint, AopInterface analysisActuator)
    {  
    	log.info("AopAnnotationt AfterThrow2 {}", analysisActuator.note());
    }
    
    @AfterThrowing(value = "pointcut(analysisActuator)")
    public void doAfterThrow3(AopInterface analysisActuator)
    {  
    	log.info("AopAnnotationt AfterThrow3 {}", analysisActuator.note());
    }
*/
}
