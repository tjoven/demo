package com.example.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.example.singleton.SingleDemo.InnerClass;

/**
 * 静态内部类实现 单例模式
 * @author car
 *
 */
public class SingleDemo {

	public static void main(String[] args) {
		CEO ceo=CEO.getInstance();
		CEO ceo1=CEO.getInstance();
		System.out.println(ceo);
		System.out.println(ceo1);
		System.out.println("==================反射的结果=========================");
		CEO ceo3 = null;
		try {
			ceo3 = reflectMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ceo3);
	}
	static CEO reflectMethod() throws Exception{
		Class<? extends Object> class1= Class.forName("com.example.singleton.CEO");
		Constructor[] constructors=class1.getDeclaredConstructors();
		Constructor constructor=constructors[0];
		constructor.setAccessible(true);
		CEO ceo=(CEO) constructor.newInstance(null);
		
		return ceo;
	}
	
	public  static class InnerClass{
		public static final CEO INSTANCE=new CEO();
		static{
			System.out.println("InnerClass");
		}
	}
}
class CEO {
	public CEO(){
		System.out.println("@@");
	}
	public static CEO getInstance(){
		return InnerClass.INSTANCE;
		
	}
	 static class InnerClass{
		public static final CEO INSTANCE=new CEO();
		static{
			System.out.println("InnerClass");
		}
	}
	
}
