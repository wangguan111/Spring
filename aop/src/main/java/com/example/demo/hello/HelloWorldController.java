package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gilbertwang
 */
@RestController
public class HelloWorldController 
{
	@Autowired
	private IHelloWorldService helloWorldService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(String name)
	{
		return helloWorldService.getHelloMessage(name);
	}

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(String name)
	{
		return helloWorldService.getHiMessage(name);
	}
}
