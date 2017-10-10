package com.tjove.main;

import java.util.HashMap;

public class EqualsDemo {

	
	User user=new User(10, "tian");
	public static void main(String[] args) {
		EqualsDemo demo=new EqualsDemo();
		demo.exe();
		
	}
	void exe(){
		HashMap<User, String> map=new HashMap<EqualsDemo.User, String>();
		map.put(user, "abc");
		String string=map.get(new User(10, "tian"));
		System.out.println(string);
		System.out.println(user.equals(new User(10, "tian")));
		
		System.out.println(user);
		
	}
	
	
class User{
	int age;
	String name;
	
	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {//重写equals方法
		if (this==obj) {
			return true;
		}
		if (obj instanceof User) {
			User user=(User)obj;
			if (this.name.equals(((User) obj).name)&&this.age==user.age) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {//重写hashCode
		int result=13;
		
		result=31*result+this.age;
		result=31*result+this.name.hashCode();
		
		return result;
	}
	
	@Override
	public String toString() {
		return "age="+this.age+"  "+"name="+this.name;
	}
}
}
