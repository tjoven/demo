package com.tjove.main;

import java.util.ArrayList;

public class ArrDemo {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		
		int i = 1; 
		ArrDemo demo = new ArrDemo();
		demo.play(list,i);
		System.out.println("size:"+list.size());
		System.out.println("i:"+i);
	}

	private void play(ArrayList<String> list,int i) {
		int j = i;
		list.add("@@");
		System.out.println("size:"+list.size());
		j = 5;
		System.out.println("j:"+j);
		
	}

}
class Data{
	String name="jw";
	int age=19;
	
}
