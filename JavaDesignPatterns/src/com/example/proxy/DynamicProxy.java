package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * @author car
 *
 */
public class DynamicProxy implements InvocationHandler{

	Object object=null;
	public DynamicProxy(Object object) {
		this.object=object;
	} 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("调用    "+method.getName()+    "方法");
		return method.invoke(object, args);
	}
	
}


