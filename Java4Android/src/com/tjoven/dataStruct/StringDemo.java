package com.tjoven.dataStruct;

import java.io.IOException;
import java.util.Iterator;


public class StringDemo {
	public static void main(String[] args) {
		String[] strings = new String[5];
		
		String command = "cmd /c start C:\\Users\\car\\Desktop\\aa.txt";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
