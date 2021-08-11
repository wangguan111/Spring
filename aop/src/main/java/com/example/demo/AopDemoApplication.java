package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8081/hello?name=java
//http://localhost:8081/hi?name=java

/**
 * @author gilbertwang
 */
@SpringBootApplication
public class AopDemoApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(AopDemoApplication.class, args);
	}
}

//1.within()
//AopWithin

//2.匹配对象（this, target, bean)
//AopThis
//AopTarget
//AopBean

//3.参数匹配(execution, arg)
//AopExecution
//AopArg

//4.匹配注解(@annotation, @within, @target, @args)
//AopAnnotationt
//AopAnnotationt2
//AopWithinMark
