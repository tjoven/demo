package com.tjove.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.Vector;

public class CollectionsDemo {

	public static void main(String[] args) {
		CollectionsDemo collectionsDemo=new CollectionsDemo();
		collectionsDemo.setMethod();
		collectionsDemo.mapMethod();

	}

	private void mapMethod() {
		
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		hashMap.put(1, "one");
		hashMap.put(1, "1");
		hashMap.put(2, "two");
		hashMap.put(3, "three");
		hashMap.put(4, "four");
		
		System.out.println("@@@@@@@"+hashMap.get(1));//重复Key，value被覆盖
		System.out.println("########"+hashMap.put(1, "oonnee"));//重复key,返回旧的value
		
		Set<Integer> set=hashMap.keySet();
		Collection<String> list=(Collection<String>) hashMap.values();
		Set<Entry<Integer, String>> set1=hashMap.entrySet();
		
		for (String string : list) {
			System.out.println(string);
		}
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			String string=hashMap.get(integer);
			System.out.println(string);
		}
		
		
		for (Iterator iterator = set1.iterator(); iterator.hasNext();) {
			Entry<Integer, String> entry = (Entry<Integer, String>) iterator.next();
			Integer integer=entry.getKey();
			String string=entry.getValue();
			System.out.println(integer+"--->"+string);
			
		}
	}

	private  void setMethod() {
		HashSet<String> set=new HashSet<String>();
		set.add("a");
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		
		System.out.println(set.size());
		
		Iterator<String> iterator=set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());	
			
		}
	}

}
