package com.example.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举 实现单例模式
 * @author car
 *
 */
public class SingleDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 枚举 实现单例模式
	 */
	static void method1() throws Exception{
		Singleton singleton=Singleton.getInstance();
		Singleton singleton2=Singleton.getInstance();
		System.out.println("singleton:  "+singleton);
		System.out.println("singleton2:  "+singleton2);
		
		Class class1= Class.forName("com.example.singleton.Singleton");//报错，枚举类型不能被反射
		Constructor[] constructors=class1.getDeclaredConstructors();
		Constructor constructor=constructors[0];
		constructor.setAccessible(true);
		Singleton singleton3=(Singleton) constructor.newInstance(null);
		
		System.out.println("singleton3  "+singleton3);
		
	}
	
}
enum Singleton{
		INSTANCE;
		static Singleton getInstance(){
			return INSTANCE;
		}
		private Singleton(){
			
		}
}
