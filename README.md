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