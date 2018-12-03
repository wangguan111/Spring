package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8081/hello?name=java

@SpringBootApplication
public class AopDemoApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(AopDemoApplication.class, args);
	}
}
