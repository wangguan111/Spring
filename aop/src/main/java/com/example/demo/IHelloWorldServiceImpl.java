package com.example.demo;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IHelloWorldServiceImpl implements IHelloWorldService 
{
	final static Logger log = LoggerFactory.getLogger(IHelloWorldServiceImpl.class);

	@AopInterface(note = "get message:")
	 public String getHelloMessage(String name)
	{
		log.info("4.IHelloWorldServiceImpl {}", name);
		return "Hello " + Optional.ofNullable(name).orElse("World!");
    }
 
	 public String getHiMessage(String name)
	 {
		log.info("4.IHelloWorldServiceImpl {}", name);
		return "Hi " + Optional.ofNullable(name).orElse("World!");		 
	 }
}
