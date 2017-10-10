package com.example.singleton;

import java.lang.reflect.Constructor;
/**
 * 反射实现单例模式
 * @author car
 *
 */
public class SingleDemo3 {
	public static void main(String[] args) {
		TestSingleton singleton=TestSingleton.getInstance();
		TestSingleton singleton2=null;
		try {
			Class class1=Class.forName("com.example.singleton.TestSingleton");
			Constructor[] constructors=class1.getDeclaredConstructors();
			Constructor constructor=constructors[0];
			constructor.setAccessible(true);
			singleton2=(TestSingleton) constructor.newInstance(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("singleton:  "+singleton);
		System.out.println("singleton2: "+singleton2);
		System.out.println("singleton=singleton2: "+(singleton==singleton2));

	}

}
class TestSingleton{
	private static final TestSingleton SINGLETON=new TestSingleton();
	private TestSingleton(){
	}
	public static TestSingleton getInstance(){
		return SINGLETON;
	}
}
