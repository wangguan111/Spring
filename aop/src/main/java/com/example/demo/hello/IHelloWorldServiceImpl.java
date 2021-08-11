package com.example.demo.hello;

import java.util.Optional;

import com.example.demo.aop.AopInterfaceMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author gilbertwang
 */
@Service
public class IHelloWorldServiceImpl extends BaseServiceImpl
{
	final static Logger log = LoggerFactory.getLogger(IHelloWorldServiceImpl.class);

	@AopInterfaceMethod(note = "get message:")
	@Override
	 public String getHelloMessage(String name)
	{
		log.info("4.IHelloWorldServiceImpl {}", name);
		return "Hello " + Optional.ofNullable(name).orElse("World!");
    }
 
	 @Override
	 public String getHiMessage(String name)
	 {
		log.info("4.IHelloWorldServiceImpl {}", name);
		return "Hi " + Optional.ofNullable(name).orElse("World!");		 
	 }
}
