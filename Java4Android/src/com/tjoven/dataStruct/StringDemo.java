package com.tjoven.dataStruct;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class StringDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(3);
		map.put("a", "A");
		map.put("a", "B");
		
		System.out.println(map.get("a"));
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
		
	}
}
