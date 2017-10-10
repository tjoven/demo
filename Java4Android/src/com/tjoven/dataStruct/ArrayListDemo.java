package com.tjoven.dataStruct;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Iterator<Integer> it = list.iterator();
		System.out.println(it.next());
		it.remove();
		System.out.println(list);
	}
}
