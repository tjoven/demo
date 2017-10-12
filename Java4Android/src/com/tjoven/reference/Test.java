package com.tjoven.reference;

import java.lang.ref.WeakReference;

public class Test {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Integer a = 10;
		Integer b = 10;
		System.out.println(a==b);//true
		
		Integer a1 = 1000;
		Integer b1 = 1000;
		System.out.println(a1==b1);//false
	}
}
