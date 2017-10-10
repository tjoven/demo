package com.tjove.main;

import java.util.ArrayList;
import java.util.HashSet;

public class StringDemo {

	public static void main(String[] args) {
		StringDemo demo=new StringDemo();
		demo.practice();
		
		String string="123456";
		StringBuffer buffer=new StringBuffer(string);//StringBuffer 可变
		buffer.setLength(string.length()-1);
		System.out.println(buffer.length());
	}
	void practice(){
	try {
		System.out.println("try");
		return;
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		System.out.println("finally");
	}
		String s1="123";
		String s2="123";
		String s3=new String("123");
		String s4=new String("123");
		String s5 = "aaa";
		
		HashSet<String> set = new HashSet<String>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		set.add(s5);
		
		System.out.println(set.size());//2

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		System.out.println(s2.equals(s3));
		
		System.out.println("s1==s2:"+(s1==s2));//true
		System.out.println("s1==s3:"+(s1==s3));//false
		System.out.println("s1==s4:"+(s1==s4));//false
		System.out.println("s3==s4:"+(s3==s4));//false
		
	}
	class Entry{
		public String name;
		public int age;
		public Entry next;
		public Entry(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
	}

}
