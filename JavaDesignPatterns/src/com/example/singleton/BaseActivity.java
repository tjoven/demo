package com.example.singleton;

public class BaseActivity {
	int age;
	public BaseActivity() {
		// TODO Auto-generated constructor stub
	}
	
	public void exe() {
		System.out.println("ok"+age);
	}
	public void play(String name) {
		System.out.println("play"+name);
	}
	public void setAge(int age) {
		System.out.println("age="+age);
	}

}
