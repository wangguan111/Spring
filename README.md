# Spring

1.AOP

	@Before @After @AfterReturning @Around @AfterThrowing

	1.within()-AopWithin
	2.this,target,bean-AopThis,AopTarget,AopBean
	3.execution, arg-AopExecution,AopArg
	4.@annotation,@within,@target,@args-AopAnnotationt,AopAnnotationt2,AopWithinMark(no ok)


2.eureka

	1.etc\hosts
		127.0.0.1       server1
		127.0.0.1       server2
	2.client
		@EnableEurekaClient
	3.server
		@EnableEurekaServer
		http://localhost:20001
		http://localhost:20002

3.RabbitMQ

	rabbitmq_management:http://127.0.0.1:15672

	1.DirectExchange
		http://localhost:8083/user/save?userName=w&name=g&age=1
		8081:common 
		8082:consumer
		8083:provider

		notes:common project pom cannot have spring-boot-maven-plugin


	2.FanoutExchange

	3.TopicExchange