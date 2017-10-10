package com.example.proxy;

import java.lang.reflect.Proxy;
/**
 * 代理模式
 * @author car
 *
 */
public class ProxyPattern {
	
	public static void main(String[] args) {
		
		Laysuit customer=new Customer();
		
		/*
		 * 静态代理
		 */
		System.out.println("静态代理");
		Laysuit laysuit=new Lawyer(customer);
		laysuit.submit();
		laysuit.burden();
		System.out.println("=========================================================");
		
		/*
		 * 动态代理 代理instance动态生成
		 */
		System.out.println("动态代理");
		DynamicProxy dynamicProxy = new DynamicProxy(customer);
		
		ClassLoader classLoader = customer.getClass().getClassLoader();
		
		Laysuit proxy = (Laysuit) Proxy.newProxyInstance(classLoader, new Class[]{Laysuit.class}, dynamicProxy);
		
		proxy.submit();
		proxy.burden();
	}

}
