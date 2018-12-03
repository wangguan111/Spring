package com.example.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IHelloWorldServiceImpl implements IHelloWorldService 
{
	final static Logger log = LoggerFactory.getLogger(IHelloWorldServiceImpl.class);
	
	@AnalysisActuator(note = "get message:")
	 public String getHelloMessage(String name)
	{
		log.info("IHelloWorldServiceImpl {}", name); 
		return "Hello " + Optional.ofNullable(name).orElse("World!");
    }
}
