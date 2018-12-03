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
@Component
public class AnalysisActuatorAspect 
{
	final static Logger log = LoggerFactory.getLogger(AnalysisActuatorAspect.class);
	
	//Pointcut
	@Pointcut(value = "@annotation(analysisActuator)") 
	public void pointcut(AnalysisActuator analysisActuator) 
	{ }
	
	//除了@Around外，每个方法里都可以加或者不加参数JoinPoint,
	//JoinPoint里包含了类名、被切面的方法名，参数等属性，可供读取使用。
	//@Around参数必须为ProceedingJoinPoint，pjp.proceed相应于执行被切面的方法。
	//@AfterReturning方法里，可以加returning = “XXX”，XXX即为在controller里方法的返回值.
	//@AfterThrowing方法里，可以加throwing = "XXX"，供读取异常信息.
	
	//Before
	@Before(value = "pointcut(analysisActuator)") 
	public void doBefore1(JoinPoint joinPoint, AnalysisActuator analysisActuator)throws Exception
	{
		log.info("2.Before1 {}", analysisActuator.note()); 
	}

	@Before(value = "pointcut(analysisActuator)") 
	public void doBefore2(AnalysisActuator analysisActuator)throws Exception
	{
		log.info("3.Before2 {}", analysisActuator.note()); 
	}

	//After
	@After(value = "pointcut(analysisActuator)") 
	public void doAfter1(JoinPoint joinPoint, AnalysisActuator analysisActuator)throws Exception
	{ 
		log.info("6.After1 {}", analysisActuator.note());
	}

	@After(value = "pointcut(analysisActuator)") 
	public void doAfter2(AnalysisActuator analysisActuator)throws Exception
	{ 
		log.info("7.After2 {}", analysisActuator.note());
	}

	//AfterReturning
    @AfterReturning(returning = "ret", value = "pointcut(analysisActuator)")
    public void doAfterReturning1(JoinPoint joinPoint, Object ret, AnalysisActuator analysisActuator) throws Exception 
    {
    	log.info("8.AfterReturning1 {} {}", ret, analysisActuator.note());
    }
   
    @AfterReturning(returning = "ret", value = "pointcut(analysisActuator)")
    public void doAfterReturning2(Object ret, AnalysisActuator analysisActuator) throws Exception 
    {
    	log.info("9.AfterReturning2 {} {}", ret, analysisActuator.note());
    }
 
    @AfterReturning(value = "pointcut(analysisActuator)")
    public void doAfterReturning3(AnalysisActuator analysisActuator) throws Exception 
    {
    	log.info("10.AfterReturning3 {}", analysisActuator.note());
    }

    //Around
    @Around(value = "pointcut(analysisActuator)")  
    public Object doArround1(ProceedingJoinPoint pjp, AnalysisActuator analysisActuator) throws Throwable 
    { 
    	log.info("1.Arround1 before proceed {}", analysisActuator.note());
    	Object o =  pjp.proceed();
    	log.info("5.Arround1 after proceed {}", analysisActuator.note());
    	return o;
    }
 
    //AfterThrowing
    @AfterThrowing(value = "pointcut(analysisActuator)", throwing = "ex")
    public void doAfterThrow1(JoinPoint jp, AnalysisActuator analysisActuator, Exception ex)
    {  
    	log.info("AfterThrow1 {}", analysisActuator.note());
    }
 
    @AfterThrowing(value = "pointcut(analysisActuator)")
    public void doAfterThrow2(JoinPoint jp, AnalysisActuator analysisActuator)
    {  
    	log.info("AfterThrow2 {}", analysisActuator.note());
    }
    
    @AfterThrowing(value = "pointcut(analysisActuator)")
    public void doAfterThrow3(AnalysisActuator analysisActuator)
    {  
    	log.info("AfterThrow3 {}", analysisActuator.note());
    }
 
 /*
    //1)execution：用于匹配子表达式。
    //匹配com.example.demo包及其子包中所有类中的所有方法，返回类型任意，方法参数任意
    @Pointcut("execution(* com.example.demo.IHelloWorldServiceImpl.*.*(..))")
    public void execution()
    {}

    //2）within：用于匹配连接点所在的Java类或者包。
    //匹配类中的所有方法
    @Pointcut("within(com.example.demo)")
    public void within1()
    {}

    //匹配包及其子包中所有类中的所有方法
    @Pointcut("within(com.example..*)")
    public void within2()
    {}

    //3） this：用于向通知方法中传入代理对象的引用。
    @Before("before() && this(object)")
    public void beforeThis(Object object)
    {
		log.info("before this {}", object);    	
    }

    //4）target：用于向通知方法中传入目标对象的引用。
    @Before("before() && target(object)")
    public void beforeTarget(Object object)
    {
		log.info("before target {}", object);    	
    }

    //5）args：用于将参数传入到通知方法中。
    @Before("before() && args(age, username)")
    public void beforeArgs(int age, String username)
    {
		log.info("before args {} {}", age, username);     	
    }

    //6）@within ：用于匹配在类一级使用了参数确定的注解的类，其所有方法都将被匹配。
    //所有被@AdviceAnnotation标注的类都将匹配
    @Pointcut("@within(com.example.demo.AnalysisActuator)")
    public void within3()
    {}

    //7）@target ：和@within的功能类似，但必须要指定注解接口的保留策略为RUNTIME。
    @Pointcut("@target(com.example.demo.AnalysisActuator)")
    public void target2()
    {}

    //8）@args ：传入连接点的对象对应的Java类必须被@args指定的Annotation注解标注。
    @Before("@args(AnalysisActuator)")
    public void args()
    {
		log.info("@args");    	
    }

    //9）@annotation ：匹配连接点被它参数指定的Annotation注解的方法。
    //所有被指定注解标注的方法都将匹配。
    @Pointcut("@annotation(com.example.demo.AnalysisActuator)")
    public void before5()
    {}
  
    //10）bean：通过受管Bean的名字来限定连接点所在的Bean。该关键词是Spring2.5新增的。
    @Pointcut("bean(person)")
    public void bean()
    {}
 */
}
