package com.example.demo.hello;

import com.example.demo.aop.AopInterfaceClass;

/**
 * @author gilbertwang
 */
@AopInterfaceClass(note = "")
public class BaseServiceImpl implements IHelloWorldService
{
    @Override
    public String getHelloMessage(String name)
    {
        return null;
    }

    @Override
    public String getHiMessage(String name)
    {
        return null;
    }
}
