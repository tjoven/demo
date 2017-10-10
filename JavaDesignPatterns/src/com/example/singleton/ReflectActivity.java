package com.example.singleton;

import java.lang.reflect.Method;
/**
 * 反射练习
 * @author car
 *
 */
public class ReflectActivity{
public static void main(String[] args) {
	inject(ReflectActivity.class);
}
static void inject(Object object){
	try {
		BaseActivity activity;
		Class<?> class1 = Class.forName("com.example.singleton.BaseActivity");
		activity=(BaseActivity) class1.newInstance();
		Method method=class1.getMethod("exe");
		Method method1=class1.getMethod("play",String.class);
		Method method2=class1.getMethod("setAge",int.class);
		method.invoke(activity);
		method1.invoke(activity, "@@");
		method2.invoke(activity, 12);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
}
